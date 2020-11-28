class Solution {
    public int change(int amount, int[] coins) {
        
        int [] dp = new int [amount+1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i=coin; i<=amount; i++)
                dp[i] += dp[i-coin];
        }
        return dp[amount];
        
        
        // bottom up knapsack idea
        int length = coins.length;
        int [][] dp = new int [length+1][amount+1];
        dp[0][0] = 1;
        for (int i=1; i<=length; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - coins[i-1] >= 0)
                    dp[i][j] += dp[i][j - coins[i-1]];
            }
        }
        return dp[length][amount];
    }
}
