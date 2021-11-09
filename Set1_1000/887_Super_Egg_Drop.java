class Solution {
    public int superEggDrop(int n, int k) {
        int [][] dp = new int[n+1][k+1];
        int m = 0;
        while (dp[n][m] < k) {
            m += 1;
            for (int egg=1; egg<=n; egg++) {
                dp[egg][m] = dp[egg][m-1] + dp[egg-1][m-1] + 1;
            }
        }
        return m;
    }
}


// same code with some comments

class Solution {
    public int superEggDrop(int k, int n) {
        // k = eggs
        // n = floors
        int [][] dp = new int [k + 1][n + 1];
        int moves = 0;
        // while we are taking the moves within the number of floor available which is n
        while (dp[k][moves] < n) {
            moves++;
            for (int egg=1; egg<=k; egg++) {
                // we take 1 move to a floor, then we have 2 probabilites, egg break or may not break
                dp[egg][moves] = dp[egg - 1][moves - 1] + dp[egg][moves - 1] + 1;
            }
        }
        return moves;
    }
}