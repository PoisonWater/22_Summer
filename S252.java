import java.util.Arrays;
import java.util.PriorityQueue;

public class S252 {
    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length == 0) {
            return true;
        }

        // Input the priorityQueue with stop time ascending
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));

        // Sorted by start time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        pq.add(intervals[0][1]);

        // Looping through the starting time;
        for (int i = 1; i < intervals.length; i++) {

            // If current start time is earlier than the next finishing meeting time, return
            // false;
            if (intervals[i][0] < pq.peek()) {
                return false;
            }

            // if (intervals[i][0] >= pq.peek()) {
            pq.poll();
            pq.add(intervals[i][1]);
            // }

        }

        return true;

    }
}
