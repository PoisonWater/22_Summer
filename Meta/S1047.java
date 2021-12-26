package Meta;

import java.util.Stack;

public class S1047 {

    // USING StringBuilder AS STACK IS MUCH FASTERRR!!!
    public String removeDuplicates0(String s) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            int sbLen = sb.length();

            if (sbLen > 0 && sb.charAt(sbLen - 1) == curChar) {
                // If last character in StringBuilder is same as the current character, then
                // remove the last character from StringBuilder
                sb.setLength(sbLen - 1);
            } else {
                sb.append(curChar);
            }
        }

        return sb.toString();
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        // USING StringBuilder AS STACK IS MUCH FASTERRR!!!
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
