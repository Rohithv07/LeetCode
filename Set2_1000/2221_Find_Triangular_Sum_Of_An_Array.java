class Solution {
    public int triangularSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        for (int n = length; n > 0; n--) {
            for (int i = 1; i < n; i++) {
                nums[i - 1] += nums[i];
                nums[i - 1] %= 10;
            }
        }
        return nums[0];
    }
}