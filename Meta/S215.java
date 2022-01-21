package Meta;

import java.util.PriorityQueue;

class S215R2 {
    // R2
    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
    
    private int partition(int[] nums, int lo, int hi, int target) {
                
        // locate last element - pivot
        int pivot = nums[hi];
        
        // 2 pointers for swap
        int p1 = lo, p2 = lo;
        
        while (p2 < hi) {
            if (nums[p2] >= pivot) {
                swap(nums, p1++, p2++);
            } else {
                p2++;
            }
        }
        
        swap(nums, p1, hi);
        
        // lo - p1 - hi
        if (p1 == target) { return nums[p1]; }
        if (p1 < target) { return partition(nums, p1 + 1, hi, target); }
        // if (p1 > target) { 
        return partition(nums, lo, p1 - 1, target);
        
    }
    
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k - 1);
    }
}

class S215R {

    // QuickSelect Revisit: TODO: 重写quickSelect！
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    
    private int partition(int[] nums, int start, int end, int k) {
        
        // ！！！当不match的start end出现 说明该区间已经被sort好 且k在该区间！！！
        if (start >= end) return nums[k-1]; 
        
        int pivot = nums[end--], i = start, j = start;
        // i is the index of the place to swap
        // j is the current traversed number
        
        while (j <= end) {
            if (nums[j] > pivot) {
                swap(nums, i++, j);
            }
            
            j++;
        }
        
        swap(nums, i, end+1);
        if (i+1 == k) {
            return pivot;
        }
        if (i + 1 < k) {
            return partition(nums, i + 1, end+1, k);
        }
        return partition(nums, start, i - 1, k);
        
    }
    
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }
}

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
