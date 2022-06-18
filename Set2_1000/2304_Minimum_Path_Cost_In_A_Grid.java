class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] dp = new int [row][col];
        for (int [] element : dp) {
            Arrays.fill(element, Integer.MAX_VALUE);
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = grid[0][i]; // copy the entire first row
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < col; k++) {
                    int cost = dp[i - 1][j] + grid[i][k] + moveCost[grid[i - 1][j]][k];
                    dp[i][k] = Math.min(dp[i][k], cost);
                }
            }
        }
        for (int i = 0; i < col; i++) {
            result = Math.min(result, dp[row - 1][i]);
        }
        return result;
    }
}