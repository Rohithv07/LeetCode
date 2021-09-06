class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int []{-1, -1};
        }
        int length = nums.length;
        int starting = -1;
        int ending = -1;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                starting = middle;
                high = middle - 1;
            }
            else if (nums[middle] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        if (starting == -1) {
            return new int []{-1, -1};
        }
        low = 0;
        high = length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                ending = middle;
                low = middle + 1;
            }
            else if (nums[middle] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return new int []{starting, ending};
    }
}