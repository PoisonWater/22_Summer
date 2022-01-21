package Meta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// R2
// Revisit 用 HashMap 更直观
class SparseVector1 {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    // Key - index, Value - nonzero value
    
    SparseVector1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector1 vec) {
        Set<Integer> set = vec.map.keySet();
        int ret = 0;
        for (Integer key : set) {
            if (map.containsKey(key)) {
                ret += map.get(key) * vec.map.get(key);
            }
        }
        return ret;
    }
}

class SparseVector {
    
    // Sparse: HashMap is BETTER!
    HashSet<Integer> set = new HashSet<>();
    int[] nums;
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                set.add(i);
            }
        }
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int sum = 0;
        
        // find index appeared here is on the other side.
        for (Integer index : set) {
            if (vec.set.contains(index)) {
                sum += nums[index] * vec.nums[index];
            }
        }
        
        return sum;
        
    }
}

class SparseVector2 {
    
    // Much more space - complexity
    int[] nums;
    
    SparseVector2(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * vec.nums[i];
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
