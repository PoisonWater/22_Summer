package Meta;

public class S234 {

    // ON time O1 space
    public boolean isPalindrome(ListNode head) {
        // corner case
        if (head.next == null) {
            return true;
        }
        
        // two pointer to find middle point
        ListNode lo = head, hi = head.next;
        
        while (hi != null && hi.next != null) {
            lo = lo.next;
            hi = hi.next.next;
        }
        
        // start of the list to reverse
        hi = lo.next;
        lo = null;
        
        while (hi != null) {
            ListNode tmp = hi;
            hi = hi.next;
            tmp.next = lo;
            lo = tmp;
        }
        
        // compare;
        ListNode p1 = head, p2 = lo;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
        
    }
}
