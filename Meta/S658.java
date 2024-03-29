package Meta;

import java.util.ArrayList;
import java.util.List;

public class S658 {

    // Review
    // TODO: REWRITE!!!
    // Binary Search + SLIDING WINDOW!!!
    // 一定要用Sliding Window！！！
    public List<Integer> findClosestElementsR(int[] arr, int k, int x) {
        
        // // Corner case
        // if (arr.length == 1) {
        //     return new int[]{arr[0]};
        // }
        
        // Binary Search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        // lo is the first number larger or equals to x
        
        // 2 Pointers Expand 不可以 要用sliding window
        // 因为要保持sorted且取k个 - 更简单
        hi = lo + k - 1;
        
        while (hi >= arr.length || (lo - 1 >= 0 && Math.abs(arr[hi] - x) >= Math.abs(arr[lo-1] - x))) {
            hi--;
            lo--;
        }

        // Get return
        List<Integer> ret = new ArrayList<>();
        
        for (int i = lo; i <= hi; i++) {
            ret.add(arr[i]);
        }
        
        return ret;
        
        // 注意 return 的要 sorted
        // for (int i = 1; i < k; i++) {
        //     // Out of bound
        //     if (hi >= arr.length) {
        //         lo--;
        //     } else if (lo < 0) {
        //         hi++;
        //     } else {
        //         int numHi = Math.abs(arr[hi] - x), numLo = Math.abs(arr[lo] - x);
        //         if (numHi >= numLo) {
        //             lo--;
        //         } else {
        //             hi++;
        //         }
        //     }
        // }
    }

    
    // Binary Search + sliding window
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // Search closest result
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        System.out.println(lo);
        
        // lo is the first number larger or equals to k
        
        List<Integer> ret = new ArrayList<>();
        hi = lo + k - 1;
        // lo;
        
        // sliding window
        while (hi >= arr.length || (lo>0 && arr[hi] - x >= x - arr[lo - 1])) {
            hi--;
            lo--;
        }

        
        // Forming unsorted ret
//         while (ret.size() < k) {
//             if (hi >= arr.length) {
//                 ret.add(arr[lo--]);
//             } else if (lo < 0) {
//                 ret.add(arr[hi++]);
//             } else if (arr[hi] - x < x - arr[lo]) {
//                 ret.add(arr[hi++]);
//             } else {
//                 ret.add(arr[lo--]);
//             }

//         }
        
        // finding the left starting point of the result in arr
        // , which is lo
        // int count = 0;
        // while (count < k) {
        //     if (hi >= arr.length) {
        //         lo--;
        //     } else if (lo < 0) {
        //         hi++;
        //     } else if (arr[hi] - x < x - arr[lo]) {
        //         hi++;
        //     } else {
        //         lo--;
        //     }
        //     count++;
        // }
        
        // lo总多减一个，所以这里从1开始
        for (int i = 0; i < k; i++) {
            ret.add(arr[lo + i]);
        }
        
        return ret;
        
    }
}
