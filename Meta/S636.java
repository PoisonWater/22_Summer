package Meta;

import java.util.List;
import java.util.Stack;

public class S636 {

    // Revisited
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
    

    public int[] exclusiveTime1(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[n];
        int prevTime = 0;
        
        for (String log : logs) {
            String[] info = log.split(":");
            int id = Integer.parseInt(info[0]), time = Integer.parseInt(info[2]);
            String state = info[1];
            
            // start
            if (state.equals("start")) {                
                if (!stack.isEmpty()) {
                    // update previous func time
                    int prevId = stack.peek();
                    ret[prevId] += time - prevTime;
                }
                
                // Update stack
                stack.push(id);
                
                // update prev time
                prevTime = time;
                
            } else {
                // update stack
                stack.pop();
                
                ret[id] += time + 1 - prevTime;
                
                prevTime = time + 1; // start 和 end 有 gap
            }
            
        }
        return ret;
    }

}
