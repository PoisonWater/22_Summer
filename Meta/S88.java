package Meta;

public class S88 {

    // R2
    // Revisit: 从后往前加 不会冲突
    // Merge Inplace: 因为nums1后面的位置为空，可以用mergesort从大到小merge，不会影响原有的nums1顺序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
        int p1 = m - 1, p2 = n - 1; // mergesort ptr at nums1 and nums2
        int p = m + n - 1; // ptr to add at nums1
        
        while (p >= 0) {
            if (p1 < 0) {
                nums1[p--] = nums2[p2--];
            } else if (p2 < 0) {
                return;
            } else if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        
        return;
        
    }
}
