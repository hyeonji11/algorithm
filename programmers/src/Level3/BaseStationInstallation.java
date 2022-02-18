package Level3;

public class BaseStationInstallation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int idx = 0;
        int max = w*2 + 1;

        while(now <= n) {
            if(idx >= stations.length || now < stations[idx] - w) {
                answer++;
                now += max;
            }
            else {
                now = stations[idx] + w + 1;
                idx++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        BaseStationInstallation bsi = new BaseStationInstallation();
        System.out.println(bsi.solution(11, new int[]{2, 3, 7}, 1));
    }
}
