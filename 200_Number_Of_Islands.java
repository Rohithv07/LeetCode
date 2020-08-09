class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int numberOfIslands  = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == '1')
                    numberOfIslands += dfsHelper(grid, i, j);
            }
        }
        return numberOfIslands;
    }
    public int dfsHelper(char [][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        dfsHelper(grid, i+1, j);
        dfsHelper(grid, i-1, j);
        dfsHelper(grid, i, j+1);
        dfsHelper(grid, i, j-1);
        return 1;
        
    }
}
