package Meta;

import java.util.Stack;

public class S1209 {
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
