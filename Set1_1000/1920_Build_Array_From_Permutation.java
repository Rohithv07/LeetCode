class Solution {
    public int[] buildArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int [] {};
        int length = nums.length;
        int [] result = new int [length];
        int index = 0;
        for (int num : nums) {
            result[index++] = nums[num];
        }
        return result;
    }
}
