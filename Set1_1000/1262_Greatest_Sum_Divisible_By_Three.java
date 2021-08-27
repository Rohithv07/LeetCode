class Solution {
    public int maxSumDivThree(int[] nums) {
        return maxSumDivK(nums, 3);
    }
    
    public int maxSumDivK(int [] nums, int k) {
        int [] dp = new int [3];
        for (int number : nums) {
            int [] temp = Arrays.copyOf(dp, dp.length);
            for (int value : temp) {
                dp[(value + number) % k] = Math.max(dp[(value + number) % k], value + number);
            }
        }
        return dp[0];
    }
}

// this is generalised solution for any k
