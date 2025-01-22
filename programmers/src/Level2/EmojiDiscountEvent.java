package Level2;

public class EmojiDiscountEvent {
    static int[] answer = new int[2];
    static int[] discount;
    static int[] rate = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];

        recursion(0, users, emoticons);

        return answer;
    }

    public void recursion(int depth, int[][] users, int[] emoticons) {
        if(depth == emoticons.length) {
            calculate(users, emoticons);
            return;
        }

        for(int val : rate) {
            discount[depth] = val;
            recursion(depth+1, users, emoticons);
        }
    }

    public void calculate(int[][] users, int[] emoticons) {
        int joinNum = 0;
        int total = 0;

//        for(int i=0; i<discount.length; i++) {
//            System.out.println(discount[i]);
//        }

        for(int i=0; i<users.length; i++) {
            int sum = 0;
            for(int j=0; j<emoticons.length; j++) {
                if(discount[j] >= users[i][0]) {
                    sum += emoticons[j]*(100-discount[j])/100;
                }
            }
            if(sum >= users[i][1]) {
                joinNum++;
                sum = 0;
            }
            total += sum;
        }

        if(joinNum > answer[0]) {
            answer[0] = joinNum;
            answer[1] = total;
        } else if(joinNum == answer[0]) {
            answer[1] = Math.max(answer[1], total);
        }

//        System.out.println("total : "+answer[0]+", "+answer[1]);
    }
    public static void main(String[] args) {
        EmojiDiscountEvent ed = new EmojiDiscountEvent();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        int[] result = ed.solution(users, emoticons);

        System.out.println(result[0]+", "+result[1]);
    }
}
