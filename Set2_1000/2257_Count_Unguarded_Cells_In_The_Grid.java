class Solution {
    
    private final int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] grid = buildGrid(m, n, guards, walls);
        int remainingSpace = m * n - guards.length - walls.length;
        // consider only guard
        // 1 means guarded, -1 means walls, 2 means being guarded by the guards and 0 is unguarded
        for (int [] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                while (isSafe(newX, newY, grid, m, n)) {
                    if (grid[newX][newY] != 2) {
                        remainingSpace--;
                    }
                    grid[newX][newY] = 2;
                    newX += dir[0];
                    newY += dir[1];
                }
            }
        }
        return remainingSpace;
    }
    
    private boolean isSafe(int i, int j, int [][] grid, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n && grid[i][j] != 1 && grid[i][j] != -1;
    }
    
    private int countUnguarded(boolean [][] visited) {
        int count = 0;
        int row = visited.length;
        int col = visited[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private int [][] buildGrid(int m, int n, int [][] guards, int [][] walls) {
        int [][] grid = new int [m][n];
        for (int [] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 1;
        }
        for (int [] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = -1;
        }
        return grid;
    }
}