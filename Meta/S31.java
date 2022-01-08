package Meta;

class S31R {

    // Revisit: TODO: 不熟悉 还要再练
    public void nextPermutation(int[] nums) {
        // 1. First decreasing element from back: 
        //      13[5]76420
        // 2. Find first number larger than the decreasing element after the index got from 1: 
        //      13[5]7[6]420 : 6 > 5 > 4
        // 3. Swap and reverse the sub list:
        //      13[6]7[5]420 -> 136[75420]
        //      136[02457] - > 13602457
        
        int decInd = getDec(nums);
        if (decInd == -1) {
            // reverse entire array
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int firstL = findFirstLarger(nums, nums[decInd], decInd + 1);
        swap(nums, decInd, firstL);
        
        reverse(nums, decInd + 1, nums.length - 1);
        
    }
    
    // 1. First decreasing element from back: 
    private int getDec(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i - 1;
            }
        }
        return -1;
    }
    
    // 2. Find first number larger than the decreasing element after the index got from 1: 
    private int findFirstLarger(int[] nums, int target, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
    
    // Reverse Nums Function
    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }
    private void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }
}

// https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
// 1. Find longest Non-Decreasing sequence from last index;
// 2. Identify pivot;
// 3. Find Rightmost Successor to Pivot in the suffix;
// 4. Swap Pivot;
// 5. Reverse the Non-Decreasing sequence from last index;

public class S31 {

    private int indexOfLastPeak(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i-1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }
    
    private int indexOfLastGreater(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > target) {
                return i;
            }
        }
        return -1;
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        // swapping from two end, just make clear the start and end, then use while
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    public void nextPermutation(int[] nums) {
        
        // Find the peak of the last counting peak;
        int peak = indexOfLastPeak(nums);
        
        // Find the last index of the greater digit index;
        if (peak != 0) {
            int pivot = indexOfLastGreater(nums, nums[peak - 1]);
            swap(nums, pivot, peak - 1);
        }
        
        // Reverse the sublist, if peak == 0, then reverse the whole array, getting the smallest number
        reverse(nums, peak);
        
    }
    
}
