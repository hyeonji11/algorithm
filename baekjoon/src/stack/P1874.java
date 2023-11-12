package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[num];
        boolean isTrue = true;
        List<String> result = new ArrayList<>();

        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;

        for(int i=1; i<=num; i++) {
            stack.push(i);
            result.add("+");
            while(!stack.empty() && cnt < num && stack.peek() >= arr[cnt]) {
                if(cnt == num-1) {
                    if(stack.peek() != arr[cnt]) {
                        isTrue = false;
                        break;
                    }
                }
                stack.pop();
                result.add("-");
                cnt++;
            }

        }

        if(isTrue && cnt == num) {
            for(String val : result)
                System.out.println(val);
        } else
            System.out.println("NO");
    }
}
