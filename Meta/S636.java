package Meta;

import java.util.List;
import java.util.Stack;

public class S636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        // USE Stack to represent Function Call!!!
        int[] ret = new int[n];
        
        Stack<Integer> stack = new Stack<>(); // Keep track of functions in execution;
        
        int prevTimeStamp = 0;
        
        for (String s : logs) {
            
            String[] log = s.split(":");
            
            if (log[1].length() == 5) { // start
                
                if (!stack.isEmpty()) {
                    ret[stack.peek()] += Integer.parseInt(log[2]) - prevTimeStamp;
                    prevTimeStamp = Integer.parseInt(log[2]);
                }
                stack.push(Integer.parseInt(log[0]));
                
            } else { //end
                ret[stack.pop()] += Integer.parseInt(log[2]) - prevTimeStamp + 1;
                prevTimeStamp = Integer.parseInt(log[2]) + 1;
            }
            
        }
        
        return ret;
    
    }
}
