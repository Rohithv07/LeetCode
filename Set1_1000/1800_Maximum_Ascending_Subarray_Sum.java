class Solution {
    public int maxAscendingSum(int[] nums) {
        int prefixSum = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                prefixSum += nums[i];
            }
            else {
                prefixSum = nums[i];
            }
            max = Math.max(max, prefixSum);
        }
        return max;
    }
}
