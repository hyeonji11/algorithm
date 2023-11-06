package Level1;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PersonalInformationExpirationDate {
    public static void main(String[] args) {
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] result = solution("2022.05.19", terms, privacies);

        System.out.println(Arrays.toString(result));
    }

    static public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        LocalDate todayDate = LocalDate.of(Integer.parseInt(today.substring(0, 4)), Integer.parseInt(today.substring(5, 7)), Integer.parseInt(today.substring(8)));

        Map<String, Integer> termMap = new HashMap<>();
        for(String term: terms) {
            termMap.put(term.substring(0, 1), Integer.parseInt(term.substring(2)));
        }

        for(int i=0; i<privacies.length; i++) {
            String compare = privacies[i].substring(0, 10);
            int month = Integer.parseInt(compare.substring(5, 7));
            int year = Integer.parseInt(compare.substring(0, 4));
            int day = Integer.parseInt(compare.substring(8, 10));

            month += termMap.get(privacies[i].substring(11));

            if(month >12) {
                if(month % 12 == 0) {
                    year += month/12 -1;
                    month = 12;
                } else {
                    year += month/12;
                    month %= 12;
                }
            }

            LocalDate compareDate = LocalDate.of(year, month, day);
            if(todayDate.isAfter(compareDate) || todayDate.isEqual(compareDate))
                result.add(i+1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
