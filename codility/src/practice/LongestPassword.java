package practice;

public class LongestPassword {
    public int solution(String S) {
        int answer = -1;

        String[] pwArr = S.split(" ");

        for(String word : pwArr) {
            if(isValid(word)) {
                answer = Math.max(answer, word.length());
            }
        }
        return answer;

        /*
        return Arrays.stream(S.split(" ")) // 단어 배열을 스트림으로 변환
                .filter(this::isValidPassword) // 유효한 패스워드만 필터링
                .mapToInt(String::length) // 길이 변환
                .max() // 최댓값 찾기
                .orElse(-1); // 없으면 -1 반환
         */
    }

    public boolean isValid(String password) {
        int letterCount = 0, numberCount = 0;

        for(char c : password.toCharArray()) {
            if(Character.isLetter(c)) letterCount++;
            else if(Character.isDigit(c)) numberCount++;
            else return false;
        }

        return (letterCount % 2 == 0) && (numberCount % 2 == 1);
        /*
        long letterCount = word.chars().filter(Character::isLetter).count();
        long digitCount = word.chars().filter(Character::isDigit).count();

        return word.chars().allMatch(Character::isLetterOrDigit) // 특수 문자 검사
                && letterCount % 2 == 0
                && digitCount % 2 == 1;
         */
    }
    public static void main(String[] args) {
        LongestPassword lp = new LongestPassword();
        System.out.println(lp.solution("tr 0"));

    }
}
