package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for(int i=0; i<testCase; i++) {
            String func[] = br.readLine().split("");
            int num = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String arr[] = str.substring(1, str.length()-1).split(",");

            if(arr[0].isEmpty() || arr[0].isBlank())
                arr = new String[0];

            int start = 0;
            int end = arr.length-1;
            boolean isDefaultOrder = true;

            String res = "";
            for(int j=0; j<func.length; j++) {
                if(func[j].equals("R")) {
                    isDefaultOrder = !isDefaultOrder;
                } else {
                    if(start > end) {
                        res = "error";
                        break;
                    } else {
                        if(isDefaultOrder) {
                            start++;
                        } else {
                            end--;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if(!res.equals("error")) {
                sb.append("[");
                if(isDefaultOrder) {
                    for(int j=start; j<=end; j++) {
                        sb.append(arr[j]).append(",");
                    }
                } else {
                    for(int j=end; j>=start; j--) {
                        sb.append(arr[j]).append(",");
                    }
                }
                if(sb.charAt(sb.length()-1) == ',')
                    sb.deleteCharAt(sb.length()-1);
                sb.append("]");
                res = sb.toString();
            }
            System.out.println(res);
        }
    }
}
