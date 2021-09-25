class S19 {

    private int currIndex = -1;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            currIndex = 0;
            return head;
        }

        head.next = removeNthFromEnd(head.next, n);

        if (++currIndex == n) {
            return head.next;
        }

        return head;

    }
}
