package Meta;

import java.util.Stack;

public class S1249 {
    // R2
    public String minRemoveToMakeValidR2(String s) {
        StringBuilder sb = new StringBuilder();
        int ctr = 0;
        
        // 1. eliminate ) leftmost and count ( redundency
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (ctr == 0) {
                    continue;
                } else {
                    ctr--;
                }
            } else if (c == '(') {
                ctr++;
            }
            sb.append(c);
        }
        
        // 2. eliminate ( right most
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (ctr == 0) { break; }
            char c = sb.charAt(i);
            if (c == '(') {
                sb.deleteCharAt(i);
                ctr--;
            }
        }
        
        return sb.toString();
        
    }

    // Revisited
    // 由左到右删除')' 由右到左删除‘('
    public String minRemoveToMakeValid0(String s) {
        StringBuilder sb = new StringBuilder();
        int ctr = 0; // Counting Unbalanced left parenthesis
        
        // remove )
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ctr++;
            } else if (c == ')') {
                if (ctr == 0) {
                    continue;
                }
                ctr--;
            }
            sb.append(c);
        }
        
        // remove (
        for (int i = sb.length() - 1; i >= 0 && ctr > 0; i--) {
            char c = sb.charAt(i);
            if (c == '(') {
                sb.deleteCharAt(i);
                ctr--;
            }
        }
        
        return sb.toString();
        
    }

    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        // loop through the string and fill stringbuilder accordingly
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == '(') {
                stack.add(i);
                sb.append('*');
                continue;
                
            } else if (curr == ')') {
                if (stack.isEmpty()) {
                    sb.append('*');
                    continue;
                }
                sb.setCharAt(stack.pop(), '(');
                sb.append(')');
                continue;
            }
            
            sb.append(curr);
            
        }
        
        // replace placeholders
        for (int i = 0; i < sb.length(); i++) {
            char curr = sb.charAt(i);
            
            if (curr == '*') {
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        return sb.toString();
        
    }
}
