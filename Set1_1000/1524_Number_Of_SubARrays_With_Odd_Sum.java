class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int [] dp = new int [n];
        dp[0] = 0;
        if (arr[0] % 2 == 1)
            dp[0] = 1;
        int result = 0;
        result = dp[0];
        for (int i=1; i<n; i++) {
            if (arr[i] % 2 == 0)
                dp[i] = dp[i-1];
            else
                dp[i] = i - dp[i-1] + 1;
            result = (result + dp[i] ) % 1000000007;
        }
        return result;
    }
}
