package LinkedList;

public class ReverseLinkedList {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return head;

        ListNode next = head.next;
        ListNode cur = head.next;
        ListNode prev = head;

        prev.next = null;

        while(next.next != null) {
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        cur.next = prev;
        return cur;
    }
}
