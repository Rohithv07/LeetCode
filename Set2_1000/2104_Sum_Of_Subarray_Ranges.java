class Solution {
    public long subArrayRanges(int[] nums) {
        // O(n ^ 2) approach, a stack based is also there which need further research
        long totalSum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int small = nums[i];
            int large = nums[i];
            for (int j = i + 1; j < length; j++) {
                small = Math.min(small, nums[j]);
                large = Math.max(large, nums[j]);
                totalSum += (large - small);
            }
        }
        return totalSum;
    }
}