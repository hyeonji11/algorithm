package Level1;

public class PhoneNumberHide {
    public String solution(String phone_number) {
        String answer = "";
        String[] array = phone_number.split("");

        for(int i=0; i<array.length-4; i++) {
            array[i] = "*";
        }
        answer = String.join("", array);
        return answer;
    }

    public static void main(String[] args) {
        PhoneNumberHide pnh = new PhoneNumberHide();
        System.out.println(pnh.solution("01011112222"));
    }
}
