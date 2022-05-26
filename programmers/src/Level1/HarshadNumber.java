package Level1;

public class HarshadNumber {
    public boolean solution(int x) {
        String str = ""+x;
        String[] arr = str.split("");
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        if(x%sum == 0) return true;
        return false;
    }
}
