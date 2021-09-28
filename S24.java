// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class S24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) { return head; }

        ListNode newNode = swapPairs(head.next.next);

        ListNode sec = head.next;
        head.next = newNode;
        sec.next = head;
        return sec;
    }

}
