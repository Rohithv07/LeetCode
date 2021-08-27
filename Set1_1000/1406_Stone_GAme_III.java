class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int [] dp = new int [n+1];
        for (int i=n-1; i>=0; i--) {
            dp[i] = Integer.MIN_VALUE;
            for (int k=0, take=0; k<3 && k<n-i; k++) {
                take += stoneValue[i+k];
                dp[i] = Math.max(dp[i], take-dp[i+k+1]);
            }
        }
        if (dp[0] < 0)
            return "Bob";
        if (dp[0] > 0)
            return "Alice";
        return "Tie";
    }
}
