package Level3;

import java.util.ArrayList;

public class BaseStationInstallation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        //boolean[] apartment = new boolean[n];
        int[] installation = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        int max = w*2 + 1;
        int idx = 0;

        for(int i=0; i<stations.length; i++) {
            if(stations[i]-1 == 0) {
                installation[idx] = 0;
                installation[idx+1] = w;
                arr.add(0);
                arr.add(w);
            } else if(stations[i] == n) {
                installation[idx] = n-1-w;
                installation[idx+1] = n-1;
                arr.add(n-1-w);
                arr.add(n-1);
            } else {
                installation[i] = stations[i]-1-w;
                installation[idx+1] = stations[i]-1+w;
                arr.add(stations[i]-1-w);
                arr.add(stations[i]-1+w);
            }
            idx += 2;
            //int idx = stations[i]-1;
//            for(int j=idx-w; j <= idx+w; j++) {
//                apartment[j] = true;
//            }
        }
        int start = 0;
        int cnt = 0;
        /*
        for(int i=0; i<n; i++) {
            if(i%2 != 0) { // 홀수
                cnt = installation[i] - start;
                answer += cnt/max;
                if(cnt%max != 0) answer++;
            } else {
                start = installation[i] + 1;
            }
//            if(!apartment[i]) cnt++;
//            else {
//
//            }
        }

         */
        int i=0;
        while(i<arr.size()) {
            if(i%2 == 0) {
                //cnt = installation[i] - start;
                cnt = arr.get(i) - start;
                System.out.println("start, "+start);
                System.out.println(arr.get(i)+", "+cnt);
                answer += cnt/max;
                if(cnt%max != 0) answer++;
            } else {
                //start = installation[i] + 1;
                start = arr.get(i) + 1;
            }
            i++;
        }

        if(start != n) {
            cnt = n-1-start;
            answer += cnt/max;
            if(cnt%max != 0) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        BaseStationInstallation bsi = new BaseStationInstallation();
        System.out.println(bsi.solution(11, new int[]{2, 3, 7}, 1));
    }
}
