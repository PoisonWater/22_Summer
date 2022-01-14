package Meta;

import java.util.Stack;

public class S1209 {

    // Revisit
    // TODO: Minor Rewrite - 易错
    public String removeDuplicatesR(String s, int k) {
        Stack<Integer> counter = new Stack<>();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 注意empty stack！
            if (stack.isEmpty()) {
                stack.push(c);
                counter.push(1);
                continue;
            }
            
            Character cp = stack.peek();
            // same?
            if (c == cp.charValue()) {
                int count = counter.pop();
                if (++count == k) {
                    stack.pop();
                    continue;
                } else {
                    counter.push(count);
                }
            } else {
                stack.push(c);
                counter.push(1);
            }
        }
        
        // 注意正反顺序
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            int count = counter.pop();
            for (int i = 0; i < count; i++) {
                sb.append(c); // sb.insert!
            }
        }
        
        sb.reverse();
        return sb.toString();
        
    }

    public String removeDuplicates(String s, int k) {
        
        // Stack for character and occurance
        
        Stack<Character> chars = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.isEmpty() && c == chars.peek().charValue()) {
                ints.push(ints.pop()+1);
            } else {
                chars.push(c);
                ints.push(1);
            }
            
            if (ints.peek() == k) {
                chars.pop();
                ints.pop();
            }
            
        }
        
        while (!chars.isEmpty()) {
            char c = chars.pop();
            int ctr = ints.pop();
            for (int i = 0; i < ctr; i++) {
                sb.append(c);
            }
        }
        
        sb.reverse();
        return sb.toString();
    }
}
