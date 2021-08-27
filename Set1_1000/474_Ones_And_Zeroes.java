class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int [m + 1][n + 1];
        int ones = 0;
        int zeroes = 0;
        // count the number of zeros and ones
        for (String s : strs) {
            ones = countOnes(s);
            zeroes = countZeroes(s);
            for (int i=m; i>=zeroes; i--) {
                for (int j=n; j>=ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
    public int countOnes(String s) {
        int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1')
                    count += 1;
        }
        return count;
    } 
    
    public int countZeroes(String s) {
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0')
                    count += 1;
        }
        return count;
    }
}
