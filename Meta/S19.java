package Meta;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // 注意！construct virtual node for return and removal;
        ListNode sen = new ListNode(-1, head);
        ListNode ptr = head, ptrN = sen;
        
        // create n+1 gap between ptr and ptrN
        int move = n;
        while (ptr != null && move != 0) {
            move--;
            ptr = ptr.next;
        }
        
        // Corner Case
        if (move > 0) { return null; }
        
        // move ptr
        while (ptr != null) {
            ptr = ptr.next;
            ptrN = ptrN.next;
        }
        
        // delete and return
        ptrN.next = ptrN.next.next;
        return sen.next;
         
    }
}
