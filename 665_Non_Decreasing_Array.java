class Solution {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return true;
        int irregularity = 0;
        for (int i=1; i<length; i++) {
            if (nums[i] >= nums[i - 1])
                continue;
            else if (nums[i] < nums[i - 1]) {
                irregularity ++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }
        }
        return irregularity <= 1;
    }
}
