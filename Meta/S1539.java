package Meta;

public class S1539 {

    // R2
    public int findKthPositiveR2(int[] arr, int k) {
        // 2 corner cases
        if (k < arr[0]) { return k; }
        if (k > arr[arr.length - 1]) { 
            return k + arr.length;
        }
        
        // TODO: 画数字图太清楚啦
        // 0 1 2 3 4 index i
        // 1 3 5 6 9 arr[i]
        // 0 1 2 2 4 kCurr
        // kCurr = arr[i] - 1 - i;
        
        // Binary Search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int kMid = arr[mid] - mid - 1;
            
            if (kMid < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        // hi is the first index whose k smaller than k
        int kCurr = arr[hi] - 1 - hi;
        return k - kCurr + arr[hi];
        
    }

    // Revisit - TODO: binary search
    public int findKthPositiveR(int[] arr, int k) {
        // Find current missing
        int ctr = arr[0] - 1;
        // Corner Case
        if (ctr >= k) { return k; }
        // Traverse arr
        for (int i = 1; i < arr.length; i++) {
            ctr += arr[i] - arr[i-1] - 1;
            if (ctr >= k) {
                int miss = arr[i] - 1 - (ctr - k);
                return miss;
            }
        }
        // out range
        return arr[arr.length - 1] + k-ctr;        
    }

    // OLogN BinarySearch
    // 注意bin search 模版！
    public int findKthPositive0(int[] arr, int k) {
        
        // 0. if target is larger than the array's all values;
        if (arr[arr.length-1] - arr.length < k) {
            return k + arr.length; // k + diff == k + index + 1
        } else if (arr[0] - 1 >= k) {
            return k;
        } 
        
        // 1. binary search
        int lo = 0, hi = arr.length - 1, mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] - mid - 1 >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            
        }
        
        // 2. generate result
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        
        // lo是大于k的第一个index，hi是小于k的最后一个
        // lo = hi + 1
        int target = lo + k;
        
        return target;
    }
    
    // ON brute force
    public int findKthPositive(int[] arr, int k) {
                
        int ptr = 0; // ptr of larger value index
        int ctr = 0; // ctr of kth missing
        int i = 1; // current number
        
        while (true) {
            
            while (i != arr[ptr]) {
                ctr++;
                if (ctr == k) {
                    return i;
                }
                i++;
            }
            if (ptr < arr.length - 1){
                ptr++;
            }
            i++;
            
        }
    }
}
