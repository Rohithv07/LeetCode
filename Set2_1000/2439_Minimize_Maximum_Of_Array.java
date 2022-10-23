class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefixSum = 0;
        long result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefixSum += nums[i];
            result = Math.max(result, (prefixSum + i) / (i + 1));
            // (sum + i) / (i + 1) - integer ceil division
            // basically ceil(a/b) = (a + b - 1) / b
        }
        return (int)result;
    }
}