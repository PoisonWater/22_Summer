/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class S206 {
    public ListNode reverseList(ListNode head) {

        ListNode oldHead = head, newHead = null;

        while (oldHead != null) {
            newHead = new ListNode(oldHead.val, newHead);
            oldHead = oldHead.next;
        } 

        return newHead;

    }
}
