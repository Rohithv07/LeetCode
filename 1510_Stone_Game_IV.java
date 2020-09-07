class Solution {
    public boolean winnerSquareGame(int n) {
        if (n == 1)
            return true;
        boolean [] dp = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            for (int k=1; k*k<=i; k++) {
                if (dp[i - k*k] == false) {
                    dp[i] = true;
                    break;
                    }
            }
        }
        return dp[n];
    }
}
