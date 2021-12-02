package Meta;

import java.util.Stack;

public class S1249 {
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
