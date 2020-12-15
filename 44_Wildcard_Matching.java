class Solution {
    public boolean isMatch(String s, String p) {
        // here we need to understand about ? and *
        // ? -> matches any single character
        // * -> matches any sequence of character
        
        // so we are going to fill the dp boolean table and the last row column value will be our answer.
        // there are 3 difference conditions that can happen between s and p
        // if the particular character of s and p are equal or character of p == ?
        // then dp[i][j] = dp[i-1][j-1],  ie the diagonal elements
        // the other condition is if charAt p == *
        // then we need to consider 0 occurance or more occurance of charcters
        // so dp[i][j] = dp[i-1][j] || dp[i][j-1] , ie the value to the left of the table or to the top of the table
        // if none of the above conditions came like charAt s != charAt p, them dp[i][j] = false;
        
        int length1 = s.length();
        int length2 = p.length();
        
        char [] pattern = p.toCharArray();
        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int index = 0;
        boolean firstOrNot = true;
        for (int i=0; i<length2; i++) {
            if (pattern[i] == '*') {
                if (firstOrNot) {
                    pattern[index++] = pattern[i];
                    firstOrNot = false;
                }
            }
                else {
                    pattern[index++] = pattern[i];
                    firstOrNot = true;
                }
        }
        boolean [][] dp = new boolean[length1+1][index+1];
        if (index > 0  && pattern[0] == '*')
            dp[0][1] = true;
        // if both s and p are empty, then its still a match and this is our base condition
        dp[0][0] = true;
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=index; j++) {
                if (s.charAt(i-1) == pattern[j-1] || pattern[j-1] == '?') {
                    // we need to take the diagonal elemnts values from the table
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (pattern[j-1] == '*') {
                    // either the left value or the top value of the table
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[length1][index];
    }
}


// refer - https://www.youtube.com/watch?v=3ZDZ-N0EPV0
