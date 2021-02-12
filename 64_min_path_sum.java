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
