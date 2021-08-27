// ref : https://leetcode.com/problems/decode-ways-ii/discuss/105258/Java-O(N)-by-General-Solution-for-all-DP-problems


class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int mod = (int) 1e9 + 7;
        int length = s.length();
        long [] dp = new long [length + 1];
        dp[0] = 0;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i=2; i<=length; i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);
            if (second == '*') {
                dp[i] += 9 * dp[i - 1];
            }
            else if (second > '0') {
                dp[i] += dp[i - 1];
            }
            if (first == '*') {
                if (second == '*') {
                    dp[i] += 15 * dp[i - 2];
                }
                else if (second <= '6') {
                    dp[i] += 2 * dp[i - 2];
                }
                else {
                    dp[i] += dp[i - 2];
                }
            }
            else if (first == '1' || first == '9') {
                if (second == '*') {
                    if (first == '1') {
                        dp[i] += 9 * dp[i - 2];
                    }
                    else if (first == '2') {
                        dp[i] += 6 * dp[i - 2];
                    }
                }
                else if ((first - '0') * 10 + (second - '0') <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= mod;
        }
        return (int)dp[length];
    }
}