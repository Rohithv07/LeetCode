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


class Solution {
    public int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        // please consider where we are taking s and t ie in row or col
        // if s is taken as col then the first row must be filled with 1. Then if two char become equal, dp[i][j] = dp[i - 1][j - 1] + dp[ i -1][j];
        // if s is taken row then the first col must be filled with 1. Then if two char become equal, dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        for (int i=0; i<=length1; i++) {
            dp[i][0] = 1;
        }
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length1][length2];
    }
}