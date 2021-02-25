package Level1;

public class PressKeypad {
    static String[] result;

    static int[] lLoc = {0, 3};    //x, y
    static int[] rLoc = {2, 3};

    public static void insert(int idx, String str, int x, int y) {
        result[idx] = str;
        if(str.equals("L")) {
            lLoc[0] = x;
            lLoc[1] = y;
        } else {
            rLoc[0] = x;
            rLoc[1] = y;
        }
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";

        result = new String[numbers.length];

        for(int i=0; i< numbers.length; i++) {
            if(numbers[i] % 3 == 1) {
                insert(i, "L", 0, numbers[i]/3);
            }else if(numbers[i] % 3 == 0 && numbers[i] != 0) {
                insert(i, "R", 2, numbers[i]/3 - 1);
            } else {
                int[] target = new int[2];
                target[0] = 1;
                if(numbers[i] == 0)
                    target[1] = 3;
                else
                    target[1] = numbers[i]/3;

                int leftD = Math.abs(lLoc[0] - target[0]) + Math.abs(lLoc[1] - target[1]);
                int rightD = Math.abs(rLoc[0] - target[0]) + Math.abs(rLoc[1] - target[1]);

                if(leftD<rightD) {
                    insert(i, "L", target[0], target[1]);
                } else if(leftD>rightD) {
                    insert(i, "R", target[0], target[1]);
                } else {
                    if(hand.equals("left"))
                        insert(i, "L", target[0], target[1]);
                    else
                        insert(i, "R", target[0], target[1]);
                }
            }
        }

        answer = String.join("", result);

        return answer;
    }

    public static void main(String[] args) {
        PressKeypad pk = new PressKeypad();
        System.out.println(pk.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
}
