package Meta;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class S708 {
    public Node insert(Node head, int insertVal) {
        
        // 1. Empty list
        if (head == null) {
            head = new Node(insertVal); // Not Circular! 指向自己！
            head.next = head;
            return head;
        }
        
        Node ptr = head;
        while (ptr.next != head) {
            // 3. next less than curr?
            if (ptr.val > ptr.next.val) {
                // 3.1 insert value smaller than smallest
                // 3.2 insert value larger than largest
                if (ptr.next.val >= insertVal || ptr.val < insertVal) {
                    Node tmp = ptr.next;
                    ptr.next = new Node(insertVal, tmp);
                    return head;
                }
            }
            // 4. Not less 
            if (ptr.val < ptr.next.val && ptr.next.val >= insertVal && ptr.val < insertVal) { // 别忘了前后都要判断
                Node tmp = ptr.next;
                ptr.next = new Node(insertVal, tmp);
                return head;
            }
            ptr = ptr.next;
        }
        
        // 2. Next node is Head
        ptr.next = new Node(insertVal, head);
        return head;
    }
}
