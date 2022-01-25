package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// R2
// Revisited - HahsMap 维护 indecies list
public class S398 {

    // O(1) init, O(1) memory, but O(N) to pick

    // private int[] nums;
    // private Random rand;
    
    // public S398(int[] nums) {
    //     this.nums = nums;
    //     this.rand = new Random();
    // }
    
    // public int pick(int target) {
    //     int n = this.nums.length;
    //     int count = 0;
    //     int idx = 0;
    //     for (int i = 0; i < n; ++i) {
    //         // if nums[i] is equal to target, i is a potential candidate
    //         // which needs to be chosen uniformly at random
    //         if (this.nums[i] == target) {
    //             // increment the count of total candidates
    //             // available to be chosen uniformly at random
    //             count++;
    //             // we pick the current number with probability 1 / count (reservoir sampling)
    //             if (rand.nextInt(count) == 0) {
    //                 idx = i;
    //             }
    //         }
    //     }
    //     return idx;
    // }

    // ON Init O1 pick ON space hashMap
    Random r = new Random();
    HashMap<Integer, List<Integer>> map;

    public S398(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(r.nextInt(list.size()));
    }
}
