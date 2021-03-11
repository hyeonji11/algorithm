package Level2;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChattingRoom {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> hm = new HashMap<>();

        for(String str : record) {
            String[] arr = str.split(" ");
            if(arr[0].equals("Enter") || arr[0].equals("Change")) {
                hm.put(arr[1], arr[2]);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(String str : record) {
            String[] arr = str.split(" ");
            if(arr[0].equals("Enter")) {
                list.add(hm.get(arr[1])+"님이 들어왔습니다.");
            } else if(arr[0].equals("Leave")) {
                list.add(hm.get(arr[1])+"님이 나갔습니다.");
            }
        }

        answer = list.toArray(new String[list.size()]);
        return answer;
    }

    public static void main(String[] args) {
        OpenChattingRoom ocr = new OpenChattingRoom();
        String[] array = ocr.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String str : array) {
            System.out.println(str);
        }
    }
}
