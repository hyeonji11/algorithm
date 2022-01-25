package Level1;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for(int i=0; i<n; i++) {
            //answer[i] = String.format("%"+n+"s", answer[i]);      너무 느림
            int size = answer[i].length();
            for(int j=0; j<n-size; j++) {
                answer[i] = " "+answer[i];
            }

            answer[i] = answer[i].replaceAll("0", " ");
            answer[i] = answer[i].replaceAll("1", "#");
        }

        return answer;
    }

    public static void main(String[] args) {
        int n=5;
        int arr1[] = {9, 20, 28, 18, 11};
        int arr2[] = {30, 1, 21, 17, 28};
        SecretMap s = new SecretMap();
        String[] result = s.solution(n, arr1, arr2);
    }
}
