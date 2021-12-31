package Meta;

public class S1539 {

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
