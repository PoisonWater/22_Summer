package Meta;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S253 {

    // Revisited: Start time sorted array + End time sorted PQ
    // much simpler! need explanation!
    // https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    public int minMeetingRooms1(int[][] intervals) {
        
        if (intervals.length == 0) {
            return 0;
        }
        
        // sorted array 里面的meeting排队进入PQ
        // 记录 PQ 里同时最多的 meeting 数量
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // start time sorted min - max
        // Comparator of int[] 默认是object 要cast才能比较array！
        // 注意cast格式！！
        PriorityQueue<int[]> pq = new PriorityQueue((a, b) -> ((int[])a)[1] - ((int[])b)[1]); // end time sorted min - max
        int maxM = 0;
        
        for (int[] m : intervals) {
            
            while (!pq.isEmpty() && pq.peek()[1] <= m[0]) {
                pq.poll();
            }
            
            pq.add(m);
            
            if (maxM < pq.size()) {
                maxM = pq.size();
            }

        }
        
        return maxM;
    }

}
