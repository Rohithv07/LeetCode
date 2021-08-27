class Solution {
    public boolean canBeIncreasing(int[] nums) {
        // O(n ^ 2)
        for (int i=0; i<nums.length; i++) {
            boolean flag = true;
            int lastElement = -1;
            for (int j=0; j<nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[j] <= lastElement) {
                    flag = false;
                    break;
                }
                lastElement = nums[j];
            }
            if (flag)
                return true;
        }
        return false;
        
        boolean removed = false;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (removed)
                    return false;
                removed = true;
                if (i > 1 && nums[i] <= nums[i - 2])
                    nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}
