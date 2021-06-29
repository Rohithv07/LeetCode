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

// faster 3ms

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        int [][] dp = new int [row][col];
        int max = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == '0')
                    dp[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1' && i-1 >= 0 && j-1 >= 0 && (dp[i-1][j] != '0' || dp[i][j-1] != '0' || dp[i-1][j-1] != '0'))
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                else
                    dp[i][j] = matrix[i][j] - '0';
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (dp[i][j] > max)
                    max = dp[i][j];
            }
        }
        return max * max;
    }
}



class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] dp = new int [row + 1][col + 1];
        int max = 0;
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
