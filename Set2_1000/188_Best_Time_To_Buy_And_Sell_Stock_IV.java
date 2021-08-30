class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int length = prices.length;
        int [][] dp = new int [k + 1][length];
        for (int i=0; i<=k; i++) {
            int maxDiff = -prices[0];
            for (int j=0; j<length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                    maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
                }
            }
        }
        return dp[k][length - 1];
    }
}