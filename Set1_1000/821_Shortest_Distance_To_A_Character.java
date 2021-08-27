class Solution {
    public int[] shortestToChar(String S, char C) {
        // except the location of char c, make all places values as max
        int [] dp = new int [S.length()];
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != C)
                dp[i] = Integer.MAX_VALUE;
        }
        // now scan from left to right and update the value as
        // dp[i+1] = min(dp[i+1], dp[i] + 1)
        for (int i=0; i<S.length() - 1; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
        }
        // now scan from right to left again if there are multiple char c and we need the minimum
        // now we do, dp[i - 1] = min(dp[i - 1], dp[i] + 1)
        for (int i=S.length() - 1; i>0; i--) {
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }
        return dp;
    }
}
