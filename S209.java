class S209 {

    public int minSubArrayLen(int target, int[] nums) {

        int slow = 0;
        int sum = 0;
        int ret = Integer.MAX_VALUE;

        for (int fast = 0; fast < nums.length; fast++) { // For loop 遍历fast指针全部数组
            sum += nums[fast];

            while (sum >= target) { // While loop 根据 fast指针 遍历 Slow指针 的全部可能情况
                ret = Math.min(ret, fast - slow + 1);
                sum -= nums[slow++];
            }

        }

        if (ret == Integer.MAX_VALUE) {
            ret = 0;
        }

        return ret;
    }
}