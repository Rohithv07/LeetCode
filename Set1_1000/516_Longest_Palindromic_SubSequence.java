class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int subStringLength;
        int i, j;
        int [][] dp = new int [n][n];
        for (i=0; i<n; i++)
            dp[i][i] = 1;
        for (subStringLength=2; subStringLength<=n; subStringLength++) {
            for (i=0; i<n-subStringLength+1; i++) {
                j = i+subStringLength-1;
                if (s.charAt(i) == s.charAt(j) && subStringLength == 2) 
                    dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
