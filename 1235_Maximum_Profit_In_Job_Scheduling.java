class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int [][] job = new int [n][3];
        for (int i=0; i<n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }
        // sort based on endtime
        Arrays.sort(job, (a, b) -> Integer.compare(a[1], b[1]));
        int [] dp = new int [n];
        // the first value is the first profit
        dp[0] = job[0][2];
        for (int i=1; i<n; i++) {
            int currentProfit = job[i][2];
            // find the index which is best fit for current profit
            int l = search(i, job);
            if (l != -1) {
                currentProfit += dp[l];
            }
            // update the profit to the dp table
            dp[i] = Math.max(currentProfit, dp[i - 1]);
        }
        return dp[n - 1];
    }
    
    public int search(int i, int [][]job) {
        int start = 0;
        int end = i - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (job[mid][1] <= job[i][0]) {
                if (job[mid + 1][1] <= job[i][0]) {
                    start = mid + 1;
                }
                else {
                    return mid;
                }
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
