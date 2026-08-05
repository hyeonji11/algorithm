package LinkedList;

public class MaximumTwinSum {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        int[] sum = new int[50000];

        if(head.next.next == null) return head.val+head.next.val;

        int max = 0;
        int index = 0;
        ListNode cur = head;
        ListNode last = head.next;

        while(last.next != null) {
            sum[index] = cur.val;
            cur = cur.next;
            last = last.next.next;
            index++;
        }
        sum[index] = cur.val;
        cur = cur.next;

        int n = (index+1) * 2;
        for(int i=index+1; i<n; i++) {
            max = Math.max(max, sum[n-i-1]+cur.val);
            cur = cur.next;
        }

        return max;
    }
}
