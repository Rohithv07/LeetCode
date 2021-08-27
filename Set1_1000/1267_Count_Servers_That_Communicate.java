/*
Actually we take the number of 1 in a column and also in a row and save it separately.
After saving this, we again traverse throught the grid and continue check if grid[i][j] = 1 + any of the row or col of that particuar index have a count > 1, if yes we increment the connexted count
Thats the whole problem.
*/

class Solution {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1)
            return 0;
        int [] rowArray = new int [row];
        int [] colArray = new int [col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {// server present in that row and col
                    rowArray[i] += 1;
                    colArray[j] += 1;
                }
            }
        }
        int connectedServers = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1 && (rowArray[i] > 1 || colArray[j] > 1))
                    connectedServers += 1;
            }
        }
        return connectedServers;
    }
}
