package sort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1302_BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        HashMap<String, Integer> books = new HashMap<>();

        for(int i=0; i<num; i++) {
            String name = br.readLine();
            if(books.get(name) != null) {
                int count = books.get(name);
                books.put(name, ++count);
            } else
                books.put(name, 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(books.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //내림차순
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int max = list.get(0).getValue();

        for(int i=list.size()-1; i>0; i--) {
            if(list.get(i).getValue() != max)
                list.remove(i);
        }

        if(list.size() != 1) {
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    //오름차순
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
        }
        System.out.println(list.get(0).getKey());
    }
}
