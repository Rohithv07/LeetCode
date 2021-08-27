class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        int subarray = 0;
        int count = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            int number = nums[i];
            if (number >= left && number <= right) {
                subarray += i - j + 1;
                count = i - j + 1;
            }
            else if (number < left) {
                subarray += count;
            }
            else {
                count = 0;
                j = i + 1;
            }
        }
        return subarray;
    }
}

/*
2  3  7  10
10 8  7  3

*/
