class S416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        // Calculate Sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        // DP initialization
        if (sum % 2 != 0) { return false; }
        
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        
        for (int i = 0; i < nums.length + 1; i++) { dp[i][0] = 0; }
        for (int j = 0; j < target + 1; j++) { dp[0][j] = 0; }
        
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j]; // 注意！！！
                    continue;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]] + nums[i-1]);
                }
            }
        }
        
        // Debugging
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        // Return
        return dp[nums.length][target] == target;
        
    }
}