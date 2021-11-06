// SKIPPED
// https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ConferenceScheduling {
    public int maxEvents(int[][] events) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(events, (first, second) -> first[1]==second[1]?
                first[0]-second[0]:first[1]-second[1]);
        
        for(int[] event: events) {
            for(int i = event[0]; i<=event[1]; i++)
                if(set.add(i)) break;
        }
        return set.size();
    }
}
