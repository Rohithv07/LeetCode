// reference : https://www.youtube.com/watch?v=PwDqpOMwg6U

class NumMatrix {
    private int [][] dp;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int [row+1][col+1];
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // we retrieve our answer from the dp array, so we increment all the values by 1
        row2 += 1;
        col2 += 1;
        row1 += 1;
        col1 += 1;
        return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
