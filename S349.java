import java.util.HashSet;
import java.util.Set;

class S349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        // 遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        // 遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        
        // 将结果几何转为数组 -- 从HashSet到Array如果要明确class type，只能遍历！！！否则返回Object[]
        int[] resArr = new int[resSet.size()];
        int index = 0;
        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
