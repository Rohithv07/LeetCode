class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long runningSum = 0;
        int previous = -1; // we can easily find the duplicate number since sorted
        for (int num : nums) {
            if (previous == num) {
                continue;
            }
            if (num <= k) {
                runningSum += num;
                k++;
            }
            previous = num;
        }       
        long result =  (long)k * (k + 1) / 2 - runningSum;
        return result;
    }
}