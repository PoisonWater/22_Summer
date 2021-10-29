class S518 {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        
        // Looping through the number of possibilities to get i value of coins.
        // Coins first: 在循环中，order重要，保证在结果中，order不重要：
        // 因为求的是【排列】：{1,2,1} 和 {2,1,1}是同一种情况，不应该重复计算
        // Coins First可以保证element以同一顺序出现（先2再1），这样可以限制其他相同情况重复计算
        // 一个Coin面值考虑一次全部情况，下一个iteration加入下一个coin面值。
        for (int j = 0; j < coins.length; j++) { 
            for (int i = 0; i < amount + 1; i++) { 
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i-coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
