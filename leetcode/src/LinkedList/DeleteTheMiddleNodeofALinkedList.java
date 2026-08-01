package LinkedList;

public class DeleteTheMiddleNodeofALinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode mid = head;
        ListNode last = head;

        while(last != null && last.next != null) {
            prev = mid;
            mid = mid.next;
            last = last.next.next;
        }

        prev.next = mid.next;

        return head;
    }
}
