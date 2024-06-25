package Level2;

public class TargetNumber {
    public static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0);

        return answer;
    }
    public static void dfs(int sum, int target, int[] numbers, int depth) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
        } else {
            dfs(sum+numbers[depth], target, numbers, depth+1);
            dfs(sum-numbers[depth], target, numbers, depth+1);
        }

    }
    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
        int arr[] = {4, 1, 2, 1};
        System.out.println(tn.solution(arr, 4));
    }

}
