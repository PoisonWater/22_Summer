package TikTok;

public class S213 {

    // DP S198 * 2 - circular
    // https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0213.%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8DII.md

    public int rob(int[] nums) {
        if (nums.length == 1) { return nums[0]; }
        if (nums.length == 2) { return Math.max(nums[0], nums[1]); }
        
        return Math.max(robLn(nums, 0, nums.length - 2), robLn(nums, 1, nums.length - 1));
        
    }
    
    private int robLn(int[] nums, int start, int end) {
        if (start - end + 1 == 2) {return Math.max(nums[start], nums[end]);}
        
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i + start - 1 <= end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}
