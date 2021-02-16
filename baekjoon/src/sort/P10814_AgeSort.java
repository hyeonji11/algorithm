package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P10814_AgeSort {
    int age;
    String name;
    int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        P10814_AgeSort ageSort;
        List<P10814_AgeSort> ageList = new ArrayList<>();

        for(int i=0; i<num; i++) {
            String value[] = br.readLine().split(" ");
            ageSort = new P10814_AgeSort();
            ageSort.age = Integer.parseInt(value[0]);
            ageSort.name = value[1];
            ageSort.order = i;
            ageList.add(ageSort);
        }

        ageList.sort(new Comparator<P10814_AgeSort>() {
            @Override
            public int compare(P10814_AgeSort o1, P10814_AgeSort o2) {
                int age1 = o1.age;
                int age2 = o2.age;

                if(age1==age2) {
                    if(o1.order > o2.order)
                        return 1;
                    else
                        return -1;
                } else if(age1 > age2)
                    return 1;
                else
                    return -1;
            }
        });

        for(P10814_AgeSort sorted : ageList) {
            System.out.println(sorted.age+" "+sorted.name);
        }
    }
}