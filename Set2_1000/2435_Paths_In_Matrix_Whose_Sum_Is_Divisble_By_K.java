class Solution {
    
    private final int MOD = (int)(1e9 + 7);
    
    public int numberOfPaths(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1) {
            if (grid[row - 1][col - 1] % k == 0)
                return 1;
            else
                return 0;
        }
        int [][][] dp = new int [row][col][k];
        for (int [][] dd : dp) {
            for (int [] d : dd)
                Arrays.fill(d, -1);
        }
        return findTotalPaths(dp, grid, k, 0, 0, 0, row, col) % MOD;
    }
    
    private int findTotalPaths(int [][][] dp, int [][] grid, int k, int currentPathSum, int i, int j, int row, int col) {
        if (i == row - 1 && j == col - 1) {
            if ((currentPathSum + grid[i][j]) % k == 0) {
                return dp[i][j][currentPathSum] = 1;
            }
            else {
                return dp[i][j][currentPathSum] = 0;
            }
        }
        if (i >= row || j >= col) {
            return 0;
        }
        if (dp[i][j][currentPathSum] != -1) {
            return dp[i][j][currentPathSum];
        }
        int movingRight = findTotalPaths(dp, grid, k, (currentPathSum + grid[i][j]) % k, i, j + 1, row, col);
        int movingDown = findTotalPaths(dp, grid, k, (currentPathSum + grid[i][j]) % k, i + 1, j, row, col);
        return dp[i][j][currentPathSum] = (movingRight + movingDown) % MOD;
    }
}


// Converted bottom up solution from top down

class Solution {
    
    private final int MOD = (int)(1e9 + 7);
    
    public int numberOfPaths(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1) {
            if (grid[row - 1][col - 1] % k == 0)
                return 1;
            else
                return 0;
        }
        int [][][] dp = new int [row][col][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int sum = 0; sum < k; sum++) {
                    int currentSum = (sum + grid[i][j]) % k;
                    if (i > 0) {
                        dp[i][j][currentSum] = (dp[i][j][currentSum] + dp[i - 1][j][sum] )% MOD;
                    }
                    if (j > 0) {
                        dp[i][j][currentSum] = (dp[i][j][currentSum] + dp[i][j - 1][sum]) % MOD;
                    }
                }
            }
        }
        return dp[row - 1][col - 1][0];
        //return findTotalPaths(dp, grid, k, 0, 0, 0, row, col) % MOD;
    }
}