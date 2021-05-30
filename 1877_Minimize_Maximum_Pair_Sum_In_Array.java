class Solution {
    public int minPairSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            max = Math.max(max, currentSum);
            left += 1;
            right -= 1;
        }
        return max;
    }
}
