class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int [] dp = new int [n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int start = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        for (int end=0; end<n; end++) {
            sum += arr[end];
            while (sum > target)
                sum -= arr[start++];
            if (sum == target) {
                if (start>0 && dp[start - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[start-1] + end - start + 1);  // previous + length of window
                }
                best = Math.min(best, end - start + 1);
            }
            dp[end] = best;
        }
        return ans == Integer.MAX_VALUE ? -1:ans;
    }
}
