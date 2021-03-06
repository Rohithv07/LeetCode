class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [] dp = new int [amount+1];
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<n; j++) {
                if (coins[j] <= i) {
                    int subResult = dp[i-coins[j]];
                    if (subResult != Integer.MAX_VALUE && subResult+1 < dp[i])
                        dp[i] = subResult + 1;
                }
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }
}



// Another

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int max = amount + 1;
        int [] dp = new int [amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}




