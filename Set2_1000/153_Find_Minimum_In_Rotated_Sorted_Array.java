class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                return nums[middle];
            }
            if (nums[low] <= nums[middle] && nums[middle] > nums[high]) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return nums[low];
    }
}