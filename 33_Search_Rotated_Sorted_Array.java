class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right])
                left = middle + 1;
            else if (nums[middle] < nums[right])
                right = middle;
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else
            right = start;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}
