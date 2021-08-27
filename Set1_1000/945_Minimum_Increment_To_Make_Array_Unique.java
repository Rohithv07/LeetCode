class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int moves = 0;
        int previous = nums[0];
        for (int i=1; i<nums.length; i++) {
            previous = Math.max(previous + 1, nums[i]);
            moves += previous - nums[i];
        }
        return moves;
    }
}