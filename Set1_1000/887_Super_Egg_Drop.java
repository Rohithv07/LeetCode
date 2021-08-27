class Solution {
    public int superEggDrop(int n, int k) {
        int [][] dp = new int[n+1][k+1];
        int m = 0;
        while (dp[n][m] < k) {
            m += 1;
            for (int egg=1; egg<=n; egg++) {
                dp[egg][m] = dp[egg][m-1] + dp[egg-1][m-1] + 1;
            }
        }
        return m;
    }
}
