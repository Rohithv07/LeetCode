class Solution {
    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int [] answer = new int [cols];
        // a boolean flag t0 check stuck or not
        boolean isStuck = false;
        for (int col=0; col<cols; col++) {
            int previousColumn = col;
            int currentColumn = col;
            isStuck = false;
            for (int row=0; row<rows; row++) {
                previousColumn = currentColumn;
                currentColumn += grid[row][previousColumn];
                if (currentColumn < 0 || currentColumn >= cols || grid[row][previousColumn] * grid[row][currentColumn] == -1) {
                    // here the last exp checks for the slope.
                    isStuck = true;
                    break;
                }
            }
            answer[col] = isStuck ? -1 : currentColumn;
        }
        return answer;
    }
}


class Solution {
    public int[] findBall(int[][] grid) {
        if (grid == null || grid.length == 0)
            return new int []{};
        int row = grid.length;
        int col = grid[0].length;
        int [] fallingPos = new int [col];
        // we start putting the ball on every col of top rwo
        for (int i=0; i<col; i++) {
            // we wiill be starting from the top row
            int currentRow = 0;
            int currentCol = i;
            // check whether the ball reacnes down the row
            while (currentRow < row) {
                // if current val and value to the right both 1
                if (grid[currentRow][currentCol] == 1 && currentCol + 1 < col && grid[currentRow][currentCol + 1] == 1) {
                    currentRow ++;
                    currentCol ++;
                }
                // if the current value and value to left == -1
                else if (grid[currentRow][currentCol] == -1 && currentCol - 1 >= 0 && grid[currentRow][currentCol - 1] == -1) {
                    currentRow ++;
                    currentCol--;
                }
                else {
                    break;
                }
            }
            if (currentRow == row) {
                fallingPos[i] = currentCol;
            }
            else {
                fallingPos[i] = -1;
            }
        }
        return fallingPos;
    }
}
