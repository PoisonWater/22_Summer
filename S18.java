import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class S18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        ArrayList<List<Integer>> ret = new ArrayList<>();
        // Corner Cases:
        if (nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        int l, r;

        // 1st Loop:
        for (int i = 0; i < nums.length - 3; i++) {
            // 2nd Loop:
            for (int j = i + 1; j < nums.length - 2; j++) {
                l = j + 1;
                r = nums.length - 1;

                // 2-Sum
                while (l < r) {
                    if (nums[l] + nums[r] < target - nums[i] - nums[j]) {
                        l++;
                    } else if (nums[l] + nums[r] > target - nums[i] - nums[j]) {
                        r--;
                    } else {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }

                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return ret;
    }
}
