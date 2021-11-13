class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                return new int []{left + 1, right + 1};
            }
            if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return new int []{};
    }
}