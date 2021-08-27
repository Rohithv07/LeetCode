class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        // we build a new array with the leftmost ie nums[-1] = 1 and nums[length] = 1;
        int index = 1;
        int [] newNums = new int [length + 2];
        for (int number: nums)
            if (number > 0)
                newNums[index++] = number;
        newNums[0] = 1;
        newNums[index++] = 1;
        int [][] dp = new int [length+2][length+2];
        // lets start from the second ballon bursrinf
        for (int k=2; k<length+2; k++) {
            for (int left = 0; left < index - k; left ++) {
                int right = left + k;
                for (int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right]
                                              + dp[i][right] + dp[left][i]);
                }
            }
        }
        return dp[0][index-1];
    }
}
