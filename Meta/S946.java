package Meta;

import java.util.Stack;

public class S946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        // Validating Stack simulating Stack
        Stack<Integer> stack = new Stack<>();
        
        stack.push(pushed[0]);
        int ptr = 1, ptrp = 0;
        
        while (ptr < pushed.length) {
            
            if (!stack.isEmpty() && stack.peek() == popped[ptrp]) {
                stack.pop();
                ptrp++;
            } else {
                stack.push(pushed[ptr++]);
            }
            
        }
        
        for (int i = ptrp; i < popped.length; i++) {
            if (stack.isEmpty() || popped[i] != stack.pop()) {
                return false;
            }
        }
        
        return true;
        
    }
}
