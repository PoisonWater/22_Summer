package Meta;

import java.util.Stack;

public class S739 {

    // 可以有O1解法
    public int[] dailyTemperatures(int[] tem) {
        
        Stack<Integer> indSt = new Stack<>();
        int[] ret = new int[tem.length];
        
        for (int i = 0; i < tem.length; i++) {
            int currT = tem[i];
            // compare prev and update ret
            while (!indSt.isEmpty() && tem[indSt.peek()] < currT) {
                int prevIndex = indSt.pop();
                ret[prevIndex] = i - prevIndex;
            }
            
            // push current
            indSt.push(i);
        }
        
        return ret;
    }
}
