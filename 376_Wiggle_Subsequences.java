class Solution {
    public int wiggleMaxLength(int[] nums) {
        // 3 possible condtions
        // 1. a[i] > a[i-1] - up position and element before down position
        // 2. a[i] < a[i-1] - down position and element before up position
        // 3. a[i] == a[i-1]
        int up = 1;
        int down = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
}
