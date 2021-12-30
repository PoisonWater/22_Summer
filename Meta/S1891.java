package Meta;

public class S1891 {
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
