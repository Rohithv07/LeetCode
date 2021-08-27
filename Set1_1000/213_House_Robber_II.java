// here if we start from the first house, then since its circular, then we cant select the second one
// here if we start from the second house, then we can select the last one except the first house.
// so we can have 2 arrays separate from storing the valuse if we start from the first house or if we start from the second house.
// then do the same work as that of house robber 1 on passing these two arrays.


class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int length = nums.length;
        int [] dp = new int [length];
        // stores the value from 0 to n-1 (excluding)
        int [] ifFirst = Arrays.copyOfRange(nums, 0, length-1);
        // stores the value from 1 to n(excluding)
        int [] ifSecond = Arrays.copyOfRange(nums, 1, length);
        return Math.max(houseRob(ifFirst), houseRob(ifSecond));
    }
    // function that we used for house robber 1
    public int houseRob(int [] array) {
        int length = array.length;
        int [] dp = new int [length+1];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i=2; i<length; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+array[i]);
        return dp[length-1];
    }
}
