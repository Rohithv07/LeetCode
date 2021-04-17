class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 1)
            return 0;
        int count = 0;
        int secondNumber = nums[1];
        for (int i=1; i<nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                continue;
            }
            else if (nums[i - 1] == nums[i]) {
                count += 1;
                nums[i] = nums[i - 1] + 1;
            }
            else if (nums[i - 1] > nums[i]) {
                int diff = nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i] + diff;
                count += diff;
            }
        }
        return count;
    }
}
