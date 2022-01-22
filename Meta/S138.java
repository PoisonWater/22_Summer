package Meta;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-c2nvs/

// R2
// Revisited
public class S138 {
    public Node copyRandomList(Node head) {
        
        if (head == null) {return null;}
        
        // 1. add new node after the initial list 12345 -> 1122334455
        Node ptr = head;
        while (ptr != null) {
            Node tmp = new Node(ptr.val);
            tmp.next = ptr.next;
            ptr.next = tmp;
            ptr = ptr.next.next;
        }
        
        // 2. assign random;
        ptr = head;
        while (ptr != null) {
            if (ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }
            ptr = ptr.next.next;
        }
        
        // 3. extract new node
        Node ret = head.next;
        ptr = head;
        while (ptr.next.next != null) {
            Node tmp = ptr.next.next;
            ptr.next.next = ptr.next.next.next;
            ptr.next = tmp;
            ptr = tmp;
        }
        ptr.next = null;
        
        return ret;
    }
}
