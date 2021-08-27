class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int [][] dp = new int [tLength + 1][sLength + 1];
        // t char i == s char j, then dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] 
        // else the previous value dp[i][j - 1]
        for (int i=0; i<=sLength; i++) {
            dp[0][i] = 1;
        }
        for (int i=1; i<=tLength; i++) {
            for (int j=1; j<=sLength; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i -1][j - 1] + dp[i][j - 1];
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLength][sLength];
    }
}
