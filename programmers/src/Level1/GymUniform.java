package Level1;

public class GymUniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostSize = lost.length;
        int resSize = reserve.length;

        for(int i=0; i<lostSize; i++) {
            for(int j=0; j<resSize; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        for(int i=0; i<lostSize; i++) {
            for(int j=0; j<resSize; j++) {
                if(Math.abs(reserve[j] - lost[i])<2) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        int count=0;
        for(int value: lost) {
            if(value != -1) count++;
        }

        return n-count;
    }

    public static void main(String[] args) {
        GymUniform gu = new GymUniform();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(gu.solution(5,lost, reserve));
    }
}
