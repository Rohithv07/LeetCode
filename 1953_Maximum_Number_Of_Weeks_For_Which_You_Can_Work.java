// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/discuss/1375399/Java-Solution-O(n)-easy-explanation

// As long as the weeks for the longest project <= all other projects' weeks + 1, we can finish all the projects.

class Solution {
    public long numberOfWeeks(int[] milestones) {
        if (milestones == null || milestones.length == 0)
            return 0l;
        long weeks = 0l;
        long totalSumIncludingMax = 0;
        int max = -1;
        for (int number : milestones) {
            max = Math.max(max, number);
            totalSumIncludingMax += number; // we take all the number now and later subtract the max
        }
        long totalSumExceptMax = totalSumIncludingMax - max;
        if (max > totalSumExceptMax + 1) {
            return totalSumIncludingMax - (max - totalSumExceptMax - 1);
        }
        return totalSumIncludingMax;
    }
}