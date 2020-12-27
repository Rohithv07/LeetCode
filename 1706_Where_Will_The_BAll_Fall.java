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
