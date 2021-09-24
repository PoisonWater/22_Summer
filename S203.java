class S203 {

    // dummy head 虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummyHead = new ListNode(-1, head);
        ListNode ptr = dummyHead;
        
        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }

        return dummyHead.next;

    }

    
    // recursion 消耗更多内存

    // public ListNode removeElements(ListNode head, int val) {
        
    //     if (head == null) { return null; }

    //     if (head.val == val) {
    //         return removeElements(head.next, val);
    //     }

    //     head.next = removeElements(head.next, val);

    //     return head;

    // }

}
