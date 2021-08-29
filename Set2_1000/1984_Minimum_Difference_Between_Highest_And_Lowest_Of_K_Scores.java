class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        int length = nums.length;
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int end = 0;
        while (end + k - 1 < length) {
            int currentDifference = nums[end + k - 1] - nums[end];
            difference = Math.min(difference, currentDifference);
            end += 1;
        }
        return difference;
    }
}