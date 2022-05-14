class Solution {
    public int waysToSplitArray(int[] nums) {
        int length = nums.length;
        int split = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long firstPart = 0;
        for (int i = 0; i < length - 1; i++) {
            firstPart += nums[i];
            long secondPart = sum - firstPart;
            if (firstPart >= secondPart) {
                split++;
            }
        }
        return split;
    }
}