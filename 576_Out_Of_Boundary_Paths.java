class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int) 1e9 + 7;
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Long [][][] dp = new Long [m][n][maxMove + 1];
        return (int) (dfs(m, n, maxMove, startRow, startColumn, mod, directions, dp) % mod);
    }
    
    public long dfs(int m, int n, int maxMove, int i, int j, int mod, int [][] directions, Long [][][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1L;
        if (maxMove == 0)
            return 0L;
        if (dp[i][j][maxMove] != null)
            return dp[i][j][maxMove];
        dp[i][j][maxMove] = 0L;
        for (int [] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            dp[i][j][maxMove] = (dp[i][j][maxMove] + dfs(m, n, maxMove-1, x, y, mod, directions, dp) % mod) % mod;
        }
        return dp[i][j][maxMove];
    }
}
