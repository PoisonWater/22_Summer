package Meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S56 {

    // R2
    // Revisited
    public int[][] merge1(int[][] intervals) {
        
        // Sort array
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[][] ret = new int[intervals.length][2];
        ret[0] = intervals[0];
        int ptr = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            
            if (ret[ptr][1] >= curr[0] && ret[ptr][1] < curr[1]) { // prev end after / at curr start
                ret[ptr][1] = curr[1]; // update curr end time
            } else if (ret[ptr][1] < curr[0]) {// prev end before curr start
                ret[++ptr] = intervals[i];
            }
        }

        // 注意! array截取 用 Arrays.copyOfRange();
        return Arrays.copyOfRange(ret, 0, ptr+1);
        
    }

    public int[][] merge(int[][] intervals) {
        
        // 此类merge问题都按照 开始时间 进行排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0])); // Arrays.sort + Comparator
        int[][] sorted = intervals;
        
        List<int[]> ret = new ArrayList<>();
        ret.add(intervals[0]);
        int ptr = 0; // ptr for index in ret list
        for (int i = 1; i < sorted.length; i++) {
            
            // Mergable: ret.get(ptr)[1] > sorted[i][0];
            if (ret.get(ptr)[1] >= sorted[i][0]) {
                ret.get(ptr)[1] = Math.max(ret.get(ptr)[1], sorted[i][1]); // pass by reference
            } else {
                ret.add(new int[]{sorted[i][0], sorted[i][1]});
                ptr++;
            }
            
        }
        
        return ret.toArray(new int[ret.size()][]); // 注意List转Array方法 toArray!
    }
}
