//We want to get number which balances out the minimum value of the elements Prefix Sum so that we can make it a positive number and add 1 to it ,so we will be returning 1-minSum

class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;
        for (int num: nums) {
            sum += num;
            minSum = Math.min(sum, minSum);
        }
        return 1 - minSum;
    }
}
