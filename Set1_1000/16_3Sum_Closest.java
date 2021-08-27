class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int length = nums.length;
        int result = nums[0] + nums[1] + nums[length - 1];
        for (int i=2; i<length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right --;
                }
                else {
                    left ++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}