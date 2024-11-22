from flask import Flask, request, jsonify
from datetime import datetime
from math import radians, sin, cos, sqrt, atan2
import random
import pandas as pd

from app import process_patient_data

app = Flask(__name__)

# 거리 계산 함수
def calculate_distance(lat1, lon1, lat2, lon2):
    R = 6371  # 지구 반경(km)
    lat1, lon1, lat2, lon2 = map(radians, [lat1, lon1, lat2, lon2])
    dlat = lat2 - lat1
    dlon = lon2 - lon1
    a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
    c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return R * c

# 경로 계산 함수
def plan_route_logic(doctor_location, patients_data, emergency_calls):
    nearby_patients = [
        patient for patient in patients_data
        if calculate_distance(
            doctor_location[0], doctor_location[1],
            patient['location'][0], patient['location'][1]
        ) <= 5
    ]

    emergency_patients = [
        p for p in nearby_patients if p['patientid'] in emergency_calls
    ]

    # 방문 환자 수를 랜덤하게 결정
    random.seed(datetime.now().strftime('%Y%m%d'))
    total_patients_needed = random.randint(4, 7)

    if len(emergency_patients) >= total_patients_needed:
        return emergency_patients[:total_patients_needed]

    remaining_slots = total_patients_needed - len(emergency_patients)
    regular_patients = [
        p for p in nearby_patients if p['patientid'] not in emergency_calls
    ]
    return emergency_patients + regular_patients[:remaining_slots]

# 경로 거리 계산
def calc_route_distance(route_plan, doctor_location):
    distances = []
    prev_location = doctor_location

    for patient in route_plan:
        curr_location = patient['location']
        distances.append(calculate_distance(
            prev_location[0], prev_location[1],
            curr_location[0], curr_location[1]
        ))
        prev_location = curr_location

    return distances

@app.route('/plan_route', methods=['POST'])
def plan_route():
    try:
        data = request.json
        doctor_location = data.get('doctor_location')
        patients = data.get('patients', [])
        emergency_calls = data.get('emergency_calls', [])

        if not doctor_location or not isinstance(doctor_location, list) or len(doctor_location) != 2:
            return jsonify({"error": "Invalid or missing doctor_location"}), 400
        if not patients:
            return jsonify({"error": "No patients provided"}), 400

        # Calculate route and distances
        route_plan = plan_route_logic(doctor_location, patients, emergency_calls)
        route_distances = calc_route_distance(route_plan, doctor_location)

        result = {
            "route_plan": route_plan,
            "route_distances": route_distances,
            "total_patients": len(route_plan)
        }

        # Process data with external logic
        df = pd.DataFrame(result['route_plan'])
        processed_df = process_patient_data(df)

        # Generate summary
        patient_list = [
            {
                'patientid': row['patientid'],
                'remaining_days': row['remaining_days'],
                'location': [row['latitude'], row['longitude']]
            }
            for _, row in processed_df.iterrows()
        ]

        return jsonify({
            "route_plan": patient_list,
            "route_distances": route_distances,
            "total_patients": len(patient_list)
        }), 200

    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(port=5000, debug=True)