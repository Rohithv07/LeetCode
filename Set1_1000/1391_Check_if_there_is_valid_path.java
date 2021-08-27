class Solution {
    int [][][] DIR = new int[][][] {
        {{0, -1}, {0, 1}},
        {{-1, 0}, {1, 0}},
        {{0, -1}, {1, 0}},
        {{0, 1}, {1, 0}},
        {{0, -1}, {-1, 0}},
        {{0, 1}, {-1, 0}}
    };
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        return dfs(grid, m, n, 0, 0, visited);
    }
    public boolean dfs(int [][] grid, int m, int n, int row, int col, boolean [][] visited) {
        if (row == m-1 && col == n-1)
            return true;
        visited[row][col] = true;
        for (int [] nextDirection: DIR[grid[row][col]-1]) { // the next possible move
            int nextRow = row + nextDirection[0];
            int nextCol = col + nextDirection[1];
            if (nextRow<0 || nextCol<0 || nextRow>=m || nextCol>=n || visited[nextRow][nextCol])
                continue;
            for (int [] backDirection: DIR[grid[nextRow][nextCol]-1]) {  // now check whether we can go back from current position
                int backRow = nextRow + backDirection[0];
                int backCol = nextCol + backDirection[1];
                if (backRow == row && backCol == col)
                    if (dfs(grid, m, n, nextRow, nextCol, visited))
                        return true;
            }
        }
        return false;
    }
}
