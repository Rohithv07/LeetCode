// 2 approaches are discussed

// 1.

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        longestCommonSubsequence(str1, str2, dp, length1, length2);
        String result = buildTheResultString(str1, str2, length1, length2, dp);
        return result;
    }
    
    // the code for the longest common subsequence
    public void longestCommonSubsequence(String s1, String s2, int [][] dp, int length1, int length2) {
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    
    // building the final result
    public String buildTheResultString(String s1, String s2, int length1, int length2, int [][] dp) {
        StringBuilder sb = new StringBuilder();
        int i = length1 - 1;
        int j = length2 - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0 || j < 0) {
                char c = i < 0 ? s2.charAt(j--) : s1.charAt(i--);
                sb.append(c);
            }
            else if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i -= 1;
                j -= 1;
            }
            else {
                char c = dp[i][j+1] > dp[i+1][j] ? s1.charAt(i--) : s2.charAt(j--);
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}





// another method: https://www.youtube.com/watch?v=pHXntFeu6f8

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        String lcs = longestCommonSubsequence(str1, str2, length1, length2);
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        for (char ch : lcs.toCharArray()) {
            while (ch != str1.charAt(p1)) {
                sb.append(str1.charAt(p1++));
            }
            while (ch != str2.charAt(p2)) {
                sb.append(str2.charAt(p2++));
            } 
            sb.append(ch);
            p1 += 1;
            p2 += 1;
        }
        sb.append(str1.substring(p1));
        sb.append(str2.substring(p2));
        return sb.toString();
    }
    
    public String longestCommonSubsequence(String s1, String s2, int length1, int length2) {
        String [][] dp = new String [s1.length() + 1][s2.length() + 1];
        for (int i=0; i<=length1; i++) {
            for (int j=0; j<=length2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = "";
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                else
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i-1][j] : dp[i][j-1];
            }
        }
        return dp[length1][length2];
    }
}
