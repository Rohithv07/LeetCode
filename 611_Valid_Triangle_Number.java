class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int length = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i=2; i<length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right -= 1;
                }
                else {
                    left += 1;
                }
            }
        }
        return count;
    }
}