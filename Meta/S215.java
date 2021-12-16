package Meta;

import java.util.PriorityQueue;

public class S215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        
        for (int i : nums) {
            pq.add(i);
        }
        
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}

class S215_2 {
    
    private int partition(int[] nums, int start, int end) {
        
        // 1. define swapIndex, pivot value;
        int swap = -1, pivot = nums[end];
        
        // 2. traverse through all nums in range
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] > pivot) {
                swap++;
                int tmp = nums[i];
                nums[i] = nums[swap];
                nums[swap] = tmp;
            }
        }
        
        swap++;
        int tmp = nums[end];
        nums[end] = nums[swap];
        nums[swap] = tmp;
        
        return swap;
        
    }
    
    public int findKthLargest(int[] nums, int k) {

        int start = 0, end = nums.length - 1;
        
        // 一定要加start<end，不然容易出现错位情况。如果出现错位，其实说明该section已经排好，但是最后只剩两个element，造成死循环
        while (start < end) { 
            
            int index = partition(nums, start, end);
            
            if (index == k - 1) {
                return nums[k - 1];
            }
            
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
                
        }
        
        return nums[k - 1];
        
    }
}
