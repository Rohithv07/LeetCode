/*
Algorithm

If we see a 0, we gotta start off things again
If we see a positive number :
2.1. Increase length of positive mutilpicative result till now.
2.2. Increase length of negative mutilpicative result till now, unless we had not encountered any negative before.
If we see a negative number:
3.1. It's time to swap positive and negative multiplicative results' lengths and do similar task as we did in above case.
In each iteration, use the length of positive mutilpicative result to compute answer.
*/


class Solution {
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int positive = 0;
        int negative = 0;
        int result = 0;
        for (int number : nums) {
            if (number == 0) {
                positive = 0;
                negative = 0;
            }
            else if (number > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative+1;
            }
            else {
                int temp = positive;
                positive = negative == 0 ? 0 : negative+1;
                negative = temp + 1;
            }
            result = Math.max(positive, result);
        }
        return result;
    }
}