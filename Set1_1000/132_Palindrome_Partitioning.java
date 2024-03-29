// this can be further optimised

class Solution {
    private Integer[][] dp;
    private Boolean [][] palindromeString;
    public int minCut(String s) {
        dp = new Integer [s.length()][s.length()];
        palindromeString = new Boolean [s.length()][s.length()];
        return helper(s, 0, s.length() - 1);
    }
    
    public int  helper(String s, int start, int end) {
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int cut = s.length() - 1;
        for (int i=start; i<=end; i++) {
            if (isPalindrome(s, start, i)) {
                cut = Math.min(cut, 1 + helper(s, i + 1, end));
            }
        }
        dp[start][end] = cut;
        return cut;
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right --))
                return false;
        }
        return true;
    }
}

// optimised code

class Solution {
    private Integer[][] dp;
    private Boolean [][] palindrome;
    
    public int minCut(String s) {
        int length = s.length();
        dp = new Integer[length][length];
        palindrome = new Boolean[length][length];
        return helper(s, 0, length - 1);
    }
    
    public int helper(String s, int start, int end) {
        if (start ==  end || isPalindrome(s, start, end))
            return 0;
        if (dp[start][end] != null)
            return dp[start][end];
        int cut = s.length() - 1;
        for (int i=start; i<=end; i++) {
            if (isPalindrome(s, start, i)) {
                cut = Math.min(cut, 1 + helper(s, i + 1, end));
            }
        }
        dp[start][end] = cut;
        return cut;
    }
    
    public Boolean isPalindrome(String s, int start, int end) {
        if (start >= end)
            return true;
        if (palindrome[start][end] != null) {
            return palindrome[start][end];
        }
        return palindrome[start][end] = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start+1, end-1);
    }
} 
