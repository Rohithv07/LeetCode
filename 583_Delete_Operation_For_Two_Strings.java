class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int [][] dp =  new int [length1+1][length2+1];
        for (int i=0; i<=length1; i++) {
            for (int j=0; j<=length2; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[length1][length2];
    }
}

// another way of doing


// find the lcs length and subtract the lcs length from the lengths of word1 and word2

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;
        int length1 = word1.length();
        int length2 = word2.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
            }
        }
        int longestCommon = dp[length1][length2];
        return length1 - longestCommon + length2 - longestCommon;
    }
}


