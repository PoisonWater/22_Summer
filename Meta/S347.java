package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class S347 {
    public int[] topKFrequent(int[] nums, int k) {
        // key - number, value - occurance times
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Construct Map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Construct PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // int[0] number; int[1] occurance time
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        // generate output
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = pq.poll()[0];
        }
        
        return ret;
        
    }
}
