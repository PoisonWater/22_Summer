import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) { return 0; }

        // Min heap - END time
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        // Add the first meeting end time to heap
        pq.add(intervals[0][1]);

        // Iterate over remaining intervals - from index 1
        for (int i = 1; i < intervals.length; i++) {

            // If Currrent Start time later than the current earliest ending meeting
            // Take out the old team.
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with
            // updated end time, because the old team was removed from the room.
            pq.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the
        // meetings.
        return pq.size();
    }
    
}