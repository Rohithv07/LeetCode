class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);
        int [] dp = new int [n];
        int maximum = 0;
        for (int i=0; i<n; i++)
            dp[i] = 1;
            for (int i=1; i<n; i++) {
                for (int j=0; j<i; j++) {
                    if (pairs[i][0]>pairs[j][1] && dp[i] < dp[j] + 1)
                        dp[i] =dp[j]+1;
                 }
            }
            for (int i=0; i<n; i++)
                if (maximum < dp[i])
                    maximum = dp[i];
        return maximum;
    }
}
