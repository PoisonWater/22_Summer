package Meta;

import java.util.Stack;

public class S227 {

    // R2
    public int calculateR2(String s) {
        
        // All numbers to be added at last
        Stack<Integer> stack = new Stack<>();
        
        char prevOp = '+';
        int num = 0;
        
        // Cases
        int p = 0;
        while (p < s.length()) {
            char c = s.charAt(p++);
            
            // space
            if (c == ' ') {
                
            // number
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                
            // Operand
            } else {
                if (prevOp == '*') {
                    stack.push(stack.pop() * num);
                } else if (prevOp == '/') {
                    stack.push(stack.pop() / num);
                } else if (prevOp == '-') {
                    stack.push(-num);
                } else {
                    stack.push(num);
                }
                
                // Refresh
                num = 0;
                prevOp = c;
            }
        }
        
        // last number
        if (prevOp == '*') {
            stack.push(stack.pop() * num);
        } else if (prevOp == '/') {
            stack.push(stack.pop() / num);
        } else if (prevOp == '-') {
            stack.push(-num);
        } else {
            stack.push(num);
        }
        
        // ret
        int ret = 0;
        for (Integer i : stack) {
            ret += i;
        }
        
        return ret;
        
    }

    // Revisit
    // 用stack模拟运算：
    // 加法直接加；减法加负数；乘除法pop出来算再push；
    // 最后stack里面是要累加的数
    public int calculateR(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] in = s.toCharArray();
        int currNum = 0;
        char op = '+';
        
        // 注意 c 和 op 不要搞混 一个是当前位char 一个是上一位 operand
        for (char c : in) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    stack.push(currNum);
                } else if (op == '-') {
                    stack.push(-currNum);
                } else if (op == '*') {
                    Integer n = stack.pop();
                    stack.push(n * currNum);
                } else if (op == '/') {
                    Integer n = stack.pop();
                    stack.push(n / currNum);
                }
                op = c;
                currNum = 0;
            }
        }
        
        // Last number
        if (op == '+') {
            stack.push(currNum);
        } else if (op == '-') {
            stack.push(-currNum);
        } else if (op == '*') {
            Integer n = stack.pop();
            stack.push(n * currNum);
        } else if (op == '/') {
            Integer n = stack.pop();
            stack.push(n / currNum);
        }
        
        // add to result
        int ret = 0;
        for (Integer n : stack) {
            ret += n;
        }
        
        return ret;

    }



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
