import java.util.HashSet;

class S142 {

    // 1. HashSet

    public ListNode detectCycle(ListNode head) {

        // Corner cases:
        if (head == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        ListNode ptr = head;

        while (ptr.next != null) {
            if (set.contains(ptr)) {
                return ptr;
            }
            set.add(ptr);
            ptr = ptr.next;
        }

        return null;

    }


    // // 2. Fast / Slow Ptr

    // public ListNode detectCycle(ListNode head) {

    //     ListNode fast = head, slow = head;

    //     while (fast != null || fast.next != null) {
            
    //     }

    // }

}
