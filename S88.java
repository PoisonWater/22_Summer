class S88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int ptr = 0;
        int ptr1 = 0;
        int ptr2 = 0;

        // Merge
        while (ptr1 < m || ptr2 < n) {
            if (ptr1 == m) {
                ans[ptr] = nums2[ptr2];
                ptr2++;
            } else if (ptr2 == n) {
                ans[ptr] = nums1[ptr1];
                ptr1++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ans[ptr] = nums1[ptr1];
                ptr1 += 1;
            } else {
                ans[ptr] = nums2[ptr2];
                ptr2 += 1;
            }
            ptr++;
        }

        for (int i = 0; i < m+n; i++) {
            nums1[i] = ans[i];
        }

        return;
    }
}

// class Solution {

//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] ans = new int[m+n];
//         int ptr = 0;
//         int ptr1 = 0;
//         int ptr2 = 0;

//         // Empty
//         if (m == 0) { 
//             for (int i = 0; i < m+n; i++) { nums1[i] = nums2[i]; }
//             return;
//         }
//         if (n == 0) { return; }

//         // Merge
//         while (ptr1 < m && ptr2 < n) {
//             if (nums1[ptr1] < nums2[ptr2]) {
//                 ans[ptr] = nums1[ptr1];
//                 ptr1 += 1;
//             } else {
//                 ans[ptr] = nums2[ptr2];
//                 ptr2 += 1;
//             }
//             ptr++;
//         }

//         if (ptr1 == m) {
//             while (ptr2 < n) {
//                 ans[ptr] = nums2[ptr2];
//                 ptr2++;
//                 ptr++;
//             }
//         } else {
//             while (ptr1 < m) {
//                 ans[ptr] = nums1[ptr1];
//                 ptr1++;
//                 ptr++;
//             }
//         }

//         for (int i = 0; i < m+n; i++) {
//             nums1[i] = ans[i];
//         }

//     }
// }