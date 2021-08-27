class Solution {
    public int[] getConcatenation(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int []{};
        int length = nums.length;
        int [] result = new int [2 * length];
        for (int i=0; i<length; i++) {
            result[i] = nums[i];
            result[i + length] = nums[i];
        }
        return result;
    }
}