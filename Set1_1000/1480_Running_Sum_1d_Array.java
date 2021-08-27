/*
My thought process
So here we can finish this problem in one pass and can just modify the input with the runningSum
-> I uses a varible to keep track of the runningSum.
-> Now we go through the array and add with runningSUm.
-> Then we update the array in place with the runningSum.
-> Return the updated nums.
*/


class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int runningSum = 0;
        for (int i=0; i<length; i++) {
            runningSum += nums[i];
            nums[i] = runningSum;
        }
        return nums;
    }
}
