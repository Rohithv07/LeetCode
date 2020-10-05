class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int num: nums) {
            totalSum += num;
        }
        int checkFrom = nums.length - 1;
        int tempSum = 0;
        while (checkFrom >= 0) {
            if (tempSum <= (totalSum - tempSum)) {
                tempSum += nums[checkFrom];
                result.add(nums[checkFrom]);
            }
            checkFrom -- ;
        }
        return result;
    }
}
