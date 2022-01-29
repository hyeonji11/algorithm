package Level1;

public class RemoveMin {
    public int[] solution(int[] arr) {
        int[] answer;

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        for(int i=0; i<arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }

        answer = new int[arr.length-1];
        int num = 0;
        for(int i=0; i<arr.length; i++) {
            if(i == minIdx) continue;
            answer[num] = arr[i];
            num++;
        }

        return answer;
    }
    public static void main(String[] args) {
        RemoveMin rm = new RemoveMin();
        System.out.println(rm.solution(new int[] {4, 6, 1, 3})[0]);
    }
}
