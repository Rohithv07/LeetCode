class Solution {
    public int countTexts(String pressedKeys) {
        if (pressedKeys.length() == 1) {
            return 1;
        }
        final int MOD = (int)(1e9 + 7);
        int length = pressedKeys.length();
        int [] dp = new int [length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1] % MOD;
            if (i - 2 >= 0 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 2)) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
                if (i - 3 >= 0 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 3)) {
                    dp[i] = (dp[i] + dp[i - 3]) % MOD;
                    if ((pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9') && i - 4 >= 0 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 4)) {
                        dp[i] = (dp[i] + dp[i - 4]) % MOD;
                    }
                }
            }
        }
        return dp[length] % MOD;
    }
}