import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class S15 {
    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        int left = 1, right = nums.length - 1;
        Arrays.sort(nums);

        // Corner Cases:
        if (nums.length < 3) {
            return res;
        }

        // Arrange the first Pointer
        for (int i = 0; i < nums.length - 2; i++) {

            // Increase Performance
            if (nums[i] > 0) {
                return res;
            }

            left = i + 1;
            right = nums.length - 1;

            // 2 Sum Problem
            while (left < right) {

                if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    // Add Match
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip Duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Re-adjust
                    left++;
                    right--;
                }

            }

            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;

    }
}
