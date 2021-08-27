/*
The basic idea is to make use of dp
-> I declared a dp array of same size as that of the given matrix.
-> So say when we are at a position and if its 1, we check its top, left and the top->left part and checks whether these values are not zero. If zero means we cant say that it is a submatrix with all 1 in it. So update the dp by the corresponding matrix value as a single 1 can form a submatrix of 1x1 size.
-> If the top, left and top left from the current 1 != , then take the min from top, left and topLeft and add 1 to it as that much amount of submatrix are possible when we consider the current 1 as the bottom right corner of squre.
-> If we see a 0, then just directly uodate the corresponding dp value by 0
-> Now take the total sum from the dp array and thats our total count
-> time complexity -> O(row X col) 
-> Space complexity -> O(row X col) as new dp 2d array is creaated
*/

class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1)
            return 1;
        int [][] dp = new int [row][col];
        int sum = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else if (matrix[i][j] == 1 && i-1>=0 && j-1>=0 && (dp[i-1][j] != 0 || dp[i][j-1] != 0 || dp[i-1][j-1] != 0)) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
                else
                    dp[i][j] = matrix[i][j];
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
