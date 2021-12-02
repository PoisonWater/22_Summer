package Meta;

import java.util.HashSet;

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
