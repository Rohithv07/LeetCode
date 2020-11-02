
class Solution {
    public int countVowelStrings(int n) {
        // create a dp array of size 6
        int [] dp = new int [6];
        // dp[0] must be 0 and the rest 1
        for (int i=1; i<dp.length; i++)
            dp[i] = 1;
        for (int i=1; i<=n; i++) {
            for (int k=1; k<=5; k++) {
                dp[k] += dp[k-1];
            }
        }
        return dp[5];
    }
}


class Solution {
    public int countVowelStrings(int n) {
        // from discussions I found the answr is simply (n+4)C(4)
        return ((n+1) * (n+2) * (n+3) * (n+4)) / 24;
    }
}
