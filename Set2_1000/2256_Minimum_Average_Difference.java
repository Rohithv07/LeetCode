class Solution {
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } 
        int length = nums.length;
        long totalSum = findSum(nums);
        long [] prefixSum = findPrefixSum(nums);
        long minimumAverageDiff = Long.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            int firstLength = i + 1;
            int secondLength = length - firstLength;
            long firstAvg = prefixSum[i] / (i + 1);
            long lastAvg = secondLength == 0 ? 0 : (totalSum - prefixSum[i]) / (secondLength);
            long currentAbsDiff = Math.abs(firstAvg - lastAvg);
            if (currentAbsDiff < minimumAverageDiff) {
                minimumAverageDiff = currentAbsDiff;
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    private long findSum(int [] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    
    private long [] findPrefixSum(int [] nums) {
        int length = nums.length;
        long [] prefixSum = new long [length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }
    
}