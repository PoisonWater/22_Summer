package Twitter;
// SKIPPED
// https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/

import java.util.*;

class UniversityCareerFair {

    public int maxEvents(int[] arrival, int[] duration) {

        int NumOfEvents = arrival.length;
        int[][] events = new int[NumOfEvents][2];

        for (int i = 0; i < NumOfEvents; i++) {
            events[i] = new int[] { arrival[i], arrival[i] + duration[i] };
        }

        // 首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            // 将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            // pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            // 顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;

    }

}
