class Solution {
    public long mostPoints(int[][] questions) {
        int length = questions.length;
        long [] dp = new long [length + 1];
        for (int i=length-1; i>=0; i--) {
            int currentPoint = questions[i][0];
            int currentBrainPower = questions[i][1];
            dp[i] = currentPoint;
            if (i < length - currentBrainPower) {
                dp[i] += dp[i + currentBrainPower + 1];
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        return dp[0];
    }
}