import java.util.ArrayList;
import java.util.Arrays;

class S56 {
    public int[][] merge(int[][] intervals) {
        
        // Interval 时间问题先考虑是否可以起始时间sort！
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        // Loop and Merge
        ArrayList<int[]> list = new ArrayList<>();
        int[] toAdd = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (toAdd[1] < intervals[i][0]) {
                list.add(toAdd); //?
                toAdd = intervals[i];
            } else {
                toAdd[1] = Math.max(toAdd[1], intervals[i][1]);
            }
        }
        
        list.add(toAdd);
        
        return list.toArray(new int[list.size()][]);
        
    }
}
