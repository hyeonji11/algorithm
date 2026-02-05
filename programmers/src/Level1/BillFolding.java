package Level1;

public class BillFolding {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int min = Math.min(wallet[0], wallet[1]);
        int max = Math.max(wallet[0], wallet[1]);

        while(min < Math.min(bill[0], bill[1]) || max < Math.max(bill[0], bill[1])) {
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        BillFolding billFolding = new BillFolding();
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        System.out.println(billFolding.solution(wallet, bill));
    }
}
