class Solution {
    public boolean stoneGame(int[] piles) {
        // this is an accepted solution, just:return true;
        int n = piles.length;
        int [][] dp = new int [n][n];
        for (int i=0; i<n; i++)
            dp[i][i] = piles[i];
        for (int i=1; i<n; i++) {
            for (int j=0; j<n-i; j++) {
                dp[j][j+i] = Math.max(piles[j] - dp[j+1][i+j], piles[j+i] - dp[j][j+i-1]);
            } 
        }
        return dp[0][n-1] > 0;
    }
}
