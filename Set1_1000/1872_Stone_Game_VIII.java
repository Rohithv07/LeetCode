class Solution {
    public int stoneGameVIII(int[] stones) {
        int length = stones.length;
        int [] prefixSum = new int [length];
        prefixSum[0] = stones[0];
        for (int i=1; i<length; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        int [] dp = new int [length];
        dp[length - 1] = prefixSum[length - 1];
        for (int i=length -2 ; i>=0; i--) {
            dp[i] = Math.max(prefixSum[i] - dp[i + 1], dp[i + 1]);
        }
        return dp[1];
    }
}
