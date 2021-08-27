class Solution {
    public int minTaps(int n, int[] ranges) {
        int [] dp = new int [n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for (int i=0; i<=n; i++) {
            for (int j=Math.max(0, i - ranges[i] + 1); j<=Math.min(n, i + ranges[i]); j++) {
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
            }
        }
        return dp[n] < n + 2 ? dp[n] : -1;
    }
}


// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/discuss/506853/Java-A-general-greedy-solution-to-process-similar-problems



class Solution {
    public int minTaps(int n, int[] ranges) {
        int [] nums = new int [n + 1];
        for (int i=0; i<ranges.length; i++) {
            if (ranges[i] == 0)
                continue;
            int left = Math.max(0, i - ranges[i]);
            nums[left] = Math.max(nums[left], i + ranges[i]);
        }
        int count = 0;
        int end = 0;
        int farReach = 0;
        for (int i=0; i<nums.length && end < n; end = farReach) {
            count += 1;
            while (i < nums.length && i <= end) {
                farReach = Math.max(farReach, nums[i++]);
            }
            if (end == farReach)
                return -1;
        }
        return count;
    }
}
