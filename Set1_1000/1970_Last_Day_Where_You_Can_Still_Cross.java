// if in jth day is supposed to be the last day, then the day after that also will not be passable
// so binary search and find the possible day. if it is not possible to pass at the middle then lower days must be checked
// otherwise we need to continue checking on right side as we need the last day
// we need to make use of bfs to check whteher the jth day is passable
class Solution {
    
    private final int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        if (cells == null || row == 0 || cells.length == 0)
            return 0;
        return binarySearchDay(row, col, cells);
    }
    
    public int binarySearchDay(int row, int col, int [][] cells) {
        int left = 1;
        int right = cells.length;
        int lastDay = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isTherePossibilityToReachLast(middle, cells, row, col)) {
                // as we need to check for the last day
                left = middle + 1;
                lastDay = middle;
            }
                
            else
                right = middle - 1;
            // because the last day will be less than the middle
        }
        return lastDay;
    }
    
    public boolean isTherePossibilityToReachLast(int middle, int [][] cells, int row, int col) {
        int [][] grid = new int [row][col];
        for (int i=0; i<middle; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // we need to take care only valid top row
        for (int i=0; i<col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int []{0, i});
                grid[0][i] = 1; // visited
            }
        }
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (x == row - 1) {
                // we reached bottom row from top row
                return true;
            }
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] == 1) {
                    continue;
                }
                queue.offer(new int []{newX, newY});
                grid[newX][newY] = 1;
            }
        }
        return false;
    }
}