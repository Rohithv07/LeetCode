class Solution {
    public int stoneGameVII(int[] stones) {
        int length = stones.length;
        int [] dp = new int [length];
        for (int i=length - 1; i>=0; i--) {
            int sum = stones[i];
            for (int j=i+1; j<length; j++) {
                sum += stones[j];
                dp[j] = Math.max(sum - stones[i] - dp[j], sum - stones[j] - dp[j - 1]);
            }
        }
        return dp[length - 1];
    }
}
