package Meta;

import java.util.ArrayList;
import java.util.List;

public class S658 {
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
