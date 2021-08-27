
// dfs
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

// bfs

class Solution {
    
    private int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    queue.offer(new int [] {i, j});
                    bfsHelper(grid, queue);
                    islands += 1;
                }
            }
        }
        return islands;
    }
    
    public void bfsHelper(char [][] grid, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == '0')
                    continue;
                grid[newX][newY] = '0';
                queue.offer(new int []{newX, newY});
            }
        }
    }
}
