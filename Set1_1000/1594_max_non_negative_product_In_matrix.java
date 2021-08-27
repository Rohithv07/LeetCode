/*
My thought process
We can approach this problem by 2 methods, one is dfs and the other is generating minimum, maximum dp  array and returning the last element of maxDp if its product != -1.
We go through each of the element in the grid, we update the minDp and maxDp according to thevalue of i and j.

Key Note is the following term, which is found from the discuss section as I was not able to get the idea how to create the dp array. Its also given in the question that the man can only move in up or down direction, so thats why we only do i-1, j or i, -1 not both i-1, j-1 at the same time.
    maxDp[i][j] = Math.max(Math.max(maxDp[i-1][j] * grid[i][j], maxDp[i][j-1] * grid[i][j]), Math.max(minDp[i-1][j] * grid[i][j], minDp[i][j-1] * grid[i][j]));

    minDp[i][j] = Math.min(Math.min(minDp[i-1][j] * grid[i][j], minDp[i][j-1] * grid[i][j]), Math.min(maxDp[i-1][j] * grid[i][j], maxDp[i][j-1] * grid[i][j]));


Now returning the last element of maxDp will be the maximum non negative product.
*/



class Solution {
    public int maxProductPath(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int modulo = (int) 1e9+7;
        int row = grid.length;
        int col = grid[0].length;
        long [][] maxDp = new long[row][col];
        long [][] minDp = new long[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i == 0 && j == 0) {
                    maxDp[0][0] = grid[0][0];
                    minDp[0][0] = grid[0][0];
                }
                else if (i == 0) {
                    maxDp[0][j] = maxDp[0][j-1] * grid[0][j];
                    minDp[0][j] = minDp[0][j-1] * grid[0][j];
                }
                else if (j == 0) {
                    maxDp[i][0] = maxDp[i-1][0] * grid[i][0];
                    minDp[i][0] = minDp[i-1][0] * grid[i][0];
                }
                else {
                    maxDp[i][j] = Math.max(Math.max(maxDp[i-1][j] * grid[i][j], maxDp[i][j-1] * grid[i][j]), Math.max(minDp[i-1][j] * grid[i][j], minDp[i][j-1] * grid[i][j]));
                    minDp[i][j] = Math.min(Math.min(minDp[i-1][j] * grid[i][j], minDp[i][j-1] * grid[i][j]), Math.min(maxDp[i-1][j] * grid[i][j], maxDp[i][j-1] * grid[i][j]));
                }
            }
        }
        if (maxDp[row-1][col-1] < 0)
            return -1;
        return (int) (maxDp[row-1][col-1] % modulo); 
    }
}

/*
So the method that comes to most of our mind, dealing with grid kind of problem is DFS.
So here also we can make use of dfs to find the product in the down or the right of the grid and take the maximum.
If the maximum still remains negative, we will return -1 only.

So simple dfs will also finish this problem.

*/
class Solution {
    long result = -1;
    public int maxProductPath(int[][] grid) {
        dfsHelper(grid, 0, 0, 1);
        long modulus = (long) 1e9 + 7;
        return (int) (result % modulus);
    }
    public void dfsHelper(int [][] grid, int i, int j, long tempProduct) {
        if (i==grid.length&&j==grid[0].length || i==grid.length-1&&j==grid[0].length || i==grid.length&&j==grid[0].length-1) {
            result = Math.max(result, tempProduct);
            return;
        }
        if (i>=grid.length || j>=grid[0].length)
            return;
        if (grid[i][j] == 0) {
            result = Math.max(result, 0);
            return;
        }
        
        dfsHelper(grid, i+1, j, tempProduct*grid[i][j]);
        dfsHelper(grid, i, j+1, tempProduct*grid[i][j]);
        
    }  
}

