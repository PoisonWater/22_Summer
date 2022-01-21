package Meta;

import java.util.Arrays;

class S1762 {

    // R2
    public int[] findBuildingsR2(int[] heights) {
        
        int[] ret = new int[heights.length];
        int ptr = heights.length - 1; // place to add next bldg
        int max = 0; // max height
        
        for (int i = heights.length - 1; i >=0; i--) {
            // decide ocean view and update max height
            if (heights[i] > max) {
                ret[ptr--] = i;
                max = heights[i];
            }
        }
        
        return Arrays.copyOfRange(ret, ptr+1, heights.length);
        
    }
        
    // Use a copy of array to store data simulating LinkedList.addFirst();
    // Revisit：注意用 array 和 copyOfRange 代替 List 省时间空间，还能使用addFirst！
    public int[] findBuildings0(int[] heights) {
        int max = -1, ptr = heights.length - 1;
        int[] ret = new int[ptr+1];
        
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                ret[ptr--] = i;
            }
        }
        
        return Arrays.copyOfRange(ret, ptr + 1, heights.length);
    }
    
    public int[] findBuildings(int[] heights) {
        
        int max = -1, rInd = heights.length - 1;
        
        // retList = new LinkedList<>(); // Take too much time and space!
        int[] retList = new int[heights.length];
        
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                retList[rInd--] = i;
            }
        }
        
        // return retList.toArray(new int[retList.size()]); // Cannot do that
        
        /** Way to take List<Integers> to int[]*/
        // return retList.stream().mapToInt(Integer::intValue).toArray(); 
        return Arrays.copyOfRange(retList, rInd+1, heights.length);
        
        // O(N) Time, O(1) Space
        
    }
}
