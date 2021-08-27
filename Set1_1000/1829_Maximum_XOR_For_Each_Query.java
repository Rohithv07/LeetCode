class Solution {
    private int index = 0;
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int length = nums.length;
        int [] result = new int [length];
        int currentMax = ((int) Math.pow(2, maximumBit)) - 1; 
        int [] dp = new int [length + 1];
        for (int i=1; i<=length; i++) {
            dp[i] = dp[i - 1] ^ nums[i - 1];
        }
        helper(nums, 0, length, result, currentMax, dp);
        return result;
    }
    
    public void helper(int [] nums, int start, int end,  int [] result, int currentMax, int [] dp) {
        if (end <= 0)
            return;
        int query = dp[end];
        result[index] = currentMax ^ query;
        index += 1;
        helper(nums, start, end - 1,  result, currentMax, dp);
    }
}
