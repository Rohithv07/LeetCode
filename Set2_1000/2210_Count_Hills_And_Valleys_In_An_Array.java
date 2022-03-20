class Solution {
    public int countHillValley(int[] nums) {
        int length = nums.length;
        int countHillValley = 0;
        int previous = nums[0];
        for (int i = 1; i < length - 1; i++) {
            if (previous < nums[i] && nums[i] > nums[i + 1] || previous > nums[i] && nums[i] < nums[i + 1]) {
                previous = nums[i];
                countHillValley++;
            }
        }
        return countHillValley;
    }
}