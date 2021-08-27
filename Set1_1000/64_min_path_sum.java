class Solution {
    public int minPathSum(int[][] grid) {
        for (int i=1; i<grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int j=1; j<grid[0].length; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i=1; i<grid.length; i++) {
            for (int j=1; j<grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}



// another approach

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                else if (i == 0 && j == 0) {
                    continue;
                }
                else
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[row-1][col-1];
    }
}

// recursion + memoizartion

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int [][] dp = new int [row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                dp[i][j] = -1;
            }
        }
        return memo(grid, row - 1, col - 1, dp);
    }
    
    public int memo(int [][] grid, int row, int col, int [][] dp) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        if (row == 0 && col == 0)
            return grid[row][col];
        if (row == 0)
            return grid[row][col] + memo(grid, row, col-1, dp);
        if (col == 0)
            return grid[row][col] + memo(grid, row - 1, col, dp);
        dp[row][col] = grid[row][col] + Math.min(memo(grid, row, col-1, dp), memo(grid, row-1, col, dp));
        return dp[row][col];
    }
}
