class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int [][] directions = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int [] dir : directions) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}