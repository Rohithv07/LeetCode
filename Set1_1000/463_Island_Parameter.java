// Iterative

class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    for (int [] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) 
                            count += 1;
                    }
                }
            }
        }
        return count;
    }
}


// recursive

class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] directions = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1)
                    return dfsHelper(grid, i, j, directions);
            }
        }
        return 0;
    }
    
    public int dfsHelper(int [][] grid, int i, int j, int [][] directions) {
        int count = 0;
        grid[i][j] = -1;
        for (int [] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
                count += 1;
            else {
                if (grid[x][y] == 1)
                    count += dfsHelper(grid, x, y, directions);
            }
        }
        return count;
    }
}
