class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        obstacleGrid[0][0] = 1;
        // go through the row first
        for (int i=1; i<row; i++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)
                obstacleGrid[i][0] = 1;
            else
                obstacleGrid[i][0] = 0;
        }
        // now go through colum
        for (int i=1; i<col; i++) {
            if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1)
                obstacleGrid[0][i] = 1;
            else
                obstacleGrid[0][i] = 0;
        }
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (obstacleGrid[i][j] != 1)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                else
                    obstacleGrid[i][j] = 0;
            }
        }
        return obstacleGrid[row-1][col-1];
    }
}
