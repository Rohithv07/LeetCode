class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column;
        if (row > 0)
            column = matrix[0].length;
        else 
            column = 0;
        int [][] dp = new int[row+1][column+1];
        int length = 0;
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=column; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    length = Math.max(dp[i][j], length);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return length * length;
    }
}
