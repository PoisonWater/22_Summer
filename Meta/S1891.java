package Meta;

public class S1891 {

    // R2
    // Revisit
    public int maxLength0(int[] ribbons, int k) {
        int lo = 1, hi = Integer.MIN_VALUE; 
        // find max ribbon length
        for (int r : ribbons) {
            if (r > hi) { hi = r; }
        }
        
        // Binary Search using lo - hi
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            // Can it satisfy?
            int num = 0; // matching k
            for (int r : ribbons) {
                num += r/mid;
            }
            
            if (num < k) {
                hi = mid - 1; // hi是第一个满足条件的（return时小于lo）
            } else {
                lo = mid + 1;
            }
            
        }
        
        return hi;
    }


    // binary search
    public int maxLength(int[] ribbons, int k) {
    
        // Find min and max for the bound of length
        // int max = ribbons[0];
        // for (int i : ribbons) {
        //     if (max < i) { max = i; }
        // }
        int mid = 0, ctr = 0, start = 1, end = 100000;
        
        // traverse through ribbons
        while (start <= end) {
            mid = (end + start) / 2;
            ctr = 0;
            for (int i : ribbons) {
                ctr += i / mid;
            }

            if (ctr < k) { // not satisfactory
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return start - 1;
        
    }
}
