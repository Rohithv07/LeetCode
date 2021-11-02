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


// same stratergy slightly diff code

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length = s.length();
        int [][] dp = new int [length][length];
        for (int i=length-1; i>=0; i--) {
            dp[i][i] = 1;
            for (int j=i+1; j<length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
