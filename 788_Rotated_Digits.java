/*
dp[i] = 1   dp[i/10] ==1 && dp[i%10]==1
        2   dp[i/10] ==1 && dp[i%10]==2 ||  dp[i/10] ==2 && dp[i%10]==1
        0   other

*/
class Solution {
    public int rotatedDigits(int n) {
        if (n < 2)
            return 0;
        int [] dp = new int [n + 1];
        int count = 0;
        // dp[i] = 0 - invalid
        // dp[i] = 1 - valid and same
        // dp[i] = 2 - valid and diff
        for (int i=0; i<=n; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                }
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count += 1;
                }
            }
            else {
                int quotient = dp[i / 10];
                int remainder = dp[i % 10];
                if (quotient == 1 && remainder == 1) {
                    dp[i] = 1;
                }
                else if (quotient >= 1 && remainder >= 1) {
                    dp[i] = 2;
                    count  += 1;
                }
            }
        }
        return count;
    }
}
