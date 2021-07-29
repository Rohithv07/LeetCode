class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        // dp approach
        int mod = (int)1e9 + 7;
        long [][] dp = new long [d + 1][target + 1];
        dp[0][0] = 1l;
        for (int i=1; i<=d; i++) {
            for (int j=0; j<=target; j++) {
                for (int k=1; k<=f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return (int)(dp[d][target] % mod);
        
        // optimised dp approach
        int [][] dp = new int [d + 1][target + 1];
        for (int i=0; i<=d; i++) {
            Arrays.fill(dp[i], -1);
        }
        int mod = (int)1e9 + 7;
        return memoisation(d, f, target, dp, mod);
    }
    
    public int memoisation(int d, int f, int target, int [][] dp, int mod) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d > target || d * f < target) {
            return 0;
        }
        if (dp[d][target] != -1) {
            return dp[d][target] % mod;
        }
        int answer = 0;
        for (int i=1; i<=f && i<=target; i++) {
            if (target - i >= 0) {
                answer = (answer + memoisation(d - 1, f, target - i, dp, mod)) % mod;
            }
            else {
                break;
            }
        }
        return dp[d][target] = answer;
    }
}