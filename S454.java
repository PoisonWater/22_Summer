import java.util.HashMap;

class S454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        //// HashMap Init
        HashMap<Integer, Integer> map12 = new HashMap<>();
        // HashMap<Integer, Integer> map34 = new HashMap<>();

        // 1 & 2 Double For Loop
        int target;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                target = nums1[i] + nums2[j];
                if (!map12.containsKey(target)) {
                    map12.put(target, 1);
                } else {
                    map12.put(target, 1+map12.get(target));
                }
            }
        }

        // 3 & 4 Direct Matching
        int ret = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                target = nums3[i] + nums4[j];
                if (map12.containsKey(0 - target)) {
                    ret += map12.get(0-target);
                }
            }
        }

        return ret;

        // // 3 & 4 Double For Loop
        // for (int i = 0; i < nums3.length; i++) {
        //     for (int j = 0; j < nums4.length; j++) {
        //         target = nums3[i] + nums4[j];
        //         if (!map34.containsKey(target)) {
        //             map34.put(target, 1);
        //         } else {
        //             map34.put(target, 1+map34.get(target));
        //         }
        //     }
        // }


        // //// 0 - Matching
        
        // int ret = 0;

        // for (int i : map12.keySet()) {
        //     for (int j : map34.keySet()) {
        //         if (i + j == 0) {
        //             ret += map12.get(i) * map34.get(j);
        //         }
        //     }
        // }

        // return ret;

    }
}
