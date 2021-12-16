package Meta;

import java.util.HashSet;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

public class S1650 {

    // Better Solution, less time ON
    public Node lowestCommonAncestor0(Node p, Node q) {
        Node p1 = p, p2 = q;
        while (p1 != p2) {
            p1 = p1 == null ? q : p1.parent;
            p2 = p2 == null ? p : p2.parent;    
         }
         return p1;
   }

    // HashSet Much Slower
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> set = new HashSet<>();

        Node c1 = p, c2 = q;

        while (c1 != null && c2 != null) {

            if (set.contains(c1.val)) {
                return c1;
            }
            set.add(c1.val);

            if (set.contains(c2.val)) {
                return c2;
            }
            set.add(c2.val);

            c1 = c1.parent;
            c2 = c2.parent;

        }

        while (c1 != null) {
            if (set.contains(c1.val)) {
                return c1;
            }
            set.add(c1.val);
            c1 = c1.parent;
        }

        while (c2 != null) {
            if (set.contains(c2.val)) {
                return c2;
            }
            set.add(c2.val);
            c2 = c2.parent;
        }

        return null;

    }
}
