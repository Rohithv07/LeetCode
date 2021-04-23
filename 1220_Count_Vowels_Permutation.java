class Solution {
    public int countVowelPermutation(int n) {
        if (n == 1)
            return 5;
        if (n == 2)
            return 10;
        int mod = (int)1e9 + 7;
        // 0th index - a
        // 1st index - e
        // 2nd index - i
        // 3rd index - o
        // 4th index - u
        long [][] dp = new long [n + 1][5]; 
        
        // if n = 1, then with every letter we can create a string
        for (int i=0; i<5; i++) {
            dp[1][i] = 1;
        }
        for (int i=1; i<n; i++) {
                // a is followed in e, i, u
                dp[i + 1][0] = (dp[i][1] + dp[i][2] + dp[i][4]) % mod;
                // e is followed in a, i
                dp[i + 1][1] = (dp[i][0] + dp[i][2]) % mod;
                // i is followed in e, o
                dp[i + 1][2] = (dp[i][1] + dp[i][3]) % mod;
                // o is followed in i
                dp[i + 1][3] = (dp[i][2]) % mod;
                // u is followed in i, o
                dp[i + 1][4] = (dp[i][2] + dp[i][3]) % mod;
        }
        long answer = 0;
        for (int i=0; i<5; i++) {
            answer = (answer + dp[n][i]) % mod;
        }
        return (int) answer;
    }
}
