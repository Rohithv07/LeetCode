class Solution {
    
    private int [][] directions = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] memo = new int [row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currentLength = dfs(matrix, i, j, memo);
                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
    
    public int dfs(int [][] matrix, int i, int j, int [][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = 1;
        for (int [] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;
            int currentLength = 1 + dfs(matrix, x, y, memo);
            max = Math.max(max, currentLength);
        }
        memo[i][j] = max;
        return max;
    }
}
