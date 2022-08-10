class Solution {
    public boolean validPartition(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        int length = nums.length;
        boolean [] dp = new boolean [length];
        if (nums[0] == nums[1]) {
            dp[1] = true;
        }
        if ((nums[0] == nums[1] && nums[1] == nums[2]) || (nums[0] == nums[1] - 1 && nums[1] == nums[2] - 1)) {
            dp[2] = true;
        }
        for (int i = 3; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] |= dp[i - 2];
            }
            if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                dp[i] |= dp[i - 3];
            }
            if (nums[i] - 1 == nums[i - 1] && nums[i - 1] - 1 == nums[i - 2]) {
                dp[i] |= dp[i - 3];
            }
        }
        return dp[length - 1];
    }
}