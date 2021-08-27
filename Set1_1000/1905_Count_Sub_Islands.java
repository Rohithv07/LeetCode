/*
COunt the number of islands in grid2

If grid2's island is a subisland of grid1's island, then all the 1s in grid2 must be in the grid1 too to make it a subisland
*/


class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid1 == null && grid2 == null)
            return 0;
        int row = grid2.length;
        int col = grid2[0].length;
        int subIslands = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid2[i][j] == 1) {
                    subIslands += findSubIslands(grid1, grid2, i, j);
                }
            }
        }
        return subIslands;
    }
    
    public int findSubIslands(int [][] grid1, int [][] grid2, int i, int j) {
        /*
        Because this is the condition where we are outside the border of our island and this is where our search ends.
If we return 0 from here, then the dfs for all the tiles in the path to the border will always evaluate to zero.
If we return 1 from here, then the dfs for a tile will equal to the && of the all the tiles in the path to the border, which is what we want.
*/
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0)
            return 1;
        int result = 1;
        grid2[i][j] = 0;
        result &= findSubIslands(grid1, grid2, i+1, j);
        result &= findSubIslands(grid1, grid2, i-1, j);
        result &= findSubIslands(grid1, grid2, i, j-1);
        result &= findSubIslands(grid1, grid2, i, j+1);
        // 1 in grid2 must be a 1 in grid1
        return result & grid1[i][j];
    }
}
