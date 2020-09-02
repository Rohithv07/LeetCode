class Solution {
    int maximum = 0;
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length; 
        int column = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (grid[i][j] != 0)
                    dfsHelper(grid, i, j, 0);
            }
        }
        return maximum;
    }
    public void dfsHelper(int [][] grid, int i, int j, int current) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) {
            maximum = Math.max(current, maximum);
            return;
        }
        int value = grid[i][j];
        grid[i][j] = 0;
        dfsHelper(grid, i+1, j, current+value);
        dfsHelper(grid, i-1, j, current+value);
        dfsHelper(grid, i, j-1, current+value);
        dfsHelper(grid, i, j+1, current+value);
        grid[i][j] = value;
    }
}
