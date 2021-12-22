package Meta;

import java.util.Stack;

public class S227 {

    // Calculator uses stack!
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        stack.push(0);
        
        // Go through String for * /
        int currNum = 0;
        // s = s.replaceAll(" ", ""); // Remove all whitespaces - Slower
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (c == ' ') { continue; } // faster
                        
            // c is number 
            if (c >= '0' && c <= '9') {
                currNum = currNum * 10 + (c - '0');
                continue;
            }
            
            // c is + -
            if (op == '+') {
                stack.push(currNum);
            } else if (op == '-') {
                stack.push(-currNum);
            } else if (op == '*') {
                stack.push(stack.pop() * currNum);
            } else if (op == '/') {
                stack.push(stack.pop() / currNum);
            }
            
            op = c;
            currNum = 0;
            
        }
        
        // last number handling
        if (op == '+') {
            stack.push(currNum);
        } else if (op == '-') {
            stack.push(-currNum);
        } else if (op == '*') {
            stack.push(stack.pop() * currNum);
        } else if (op == '/') {
            stack.push(stack.pop() / currNum);
        }
        
        
        int ret = 0;
        // Pop + - to finalize result
        for (int i : stack) {
            ret += i;
        }
        return ret;
        
    }
}
