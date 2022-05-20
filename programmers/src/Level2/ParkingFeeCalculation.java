package Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ParkingFeeCalculation {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<Integer, Car> carMap = new HashMap<>();
        StringTokenizer st;
        Car car;

        for(int i=0; i<records.length; i++) {
            st = new StringTokenizer(records[i], " :");
            int time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int carNum = Integer.parseInt(st.nextToken());

            if(carMap.containsKey(carNum)) {
                car = carMap.get(carNum);
                if(st.nextToken().equals("IN")) {
                    car.inTime = time;
                } else {
                    car.totalTime += time-car.inTime;
                    car.inTime = -1;
                }
            } else {
                car = new Car();
                car.inTime = time;
            }

            carMap.put(carNum, car);
        }

        for(int key : carMap.keySet()) {
            car = carMap.get(key);
            if(car.inTime != -1) {
                car.totalTime += 1439 - car.inTime; //1439 = 23*60 + 59
            }
            if(car.totalTime <= fees[0]) {
                car.price = fees[1];
            } else {
                car.price = (int) (fees[1] + Math.ceil((car.totalTime-fees[0])/(double)fees[2]) * fees[3]);
            }
        }

        Object[] mapkey = carMap.keySet().toArray();
        Arrays.sort(mapkey);
        answer = new int[mapkey.length];

        for(int i=0; i<mapkey.length; i++) {
            answer[i] = carMap.get(mapkey[i]).price;
        }

        return answer;
    }

    public class Car {
        int inTime = -1;
        int totalTime = 0;
        int price;
    }
}
