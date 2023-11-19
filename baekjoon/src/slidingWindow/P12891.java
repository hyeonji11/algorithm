package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] alphabet = {"A", "C", "G", "T"};

        int len = Integer.parseInt(st.nextToken());
        int pw = Integer.parseInt(st.nextToken());
        String dnaStr = br.readLine();

        HashMap<String, Integer> minNum = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<alphabet.length; i++) {
            minNum.put(alphabet[i], Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = pw-1;
        int count = 1;

        String[] first = dnaStr.substring(start, end+1).split("");
        HashMap<String, Integer> compareMap = new HashMap<>();
        for(int i=0; i<alphabet.length; i++) {
            compareMap.put(alphabet[i], 0);
        }
        for(int i=0; i< first.length; i++) {
            compareMap.put(first[i], compareMap.get(first[i])+1);
        }
        for(int i=0; i<4; i++) {
            if(compareMap.get(alphabet[i]) < minNum.get(alphabet[i])) {
                count--;
                break;
            }
        }

        while(end < len-1) {
            String val = String.valueOf(dnaStr.charAt(start));
            compareMap.put(val, compareMap.get(val)-1);

            String addVal = String.valueOf(dnaStr.charAt(end+1));
            compareMap.put(addVal, compareMap.get(addVal)+1);

            count++;
            for(int i=0; i<4; i++) {
                if(compareMap.get(alphabet[i]) < minNum.get(alphabet[i])) {
                    count--;
                    break;
                }
            }

            start++;
            end++;
        }

        System.out.println(count);
    }
}
