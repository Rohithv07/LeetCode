class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int [] dp = new int [n];
        int [] count = new int [n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if (dp[i] == dp[j] + 1) 
                        count[i] += count[j];
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (dp[i] == max)
                answer += count[i];
        }
        return answer;
    }
}
