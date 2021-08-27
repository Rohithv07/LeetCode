// we can either use a 2d visited array or just change the cell to a wall to mark it as visited

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze == null || maze.length == 0)
            return -1;
        return bfs(maze, entrance);
    }
    
    public int bfs(char [][] maze, int [] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        int shortestPath = 0;
        boolean [][] visited = new boolean [row][col];
        int [][] directions = new int [][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        queue.offer(entrance);
        while (!queue.isEmpty()) {
            shortestPath ++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] currentPosition = queue.poll();
                int x = currentPosition[0];
                int y = currentPosition[1];
                for (int [] dir : directions) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX >= 0 && newY >= 0 && newX < row && newY < col && maze[newX][newY] == '.') {
                        if (newX == 0 || newX == row - 1 || newY == 0 || newY == col - 1)
                            return shortestPath;
                        maze[newX][newY] = '+';
                        queue.offer(new int []{newX, newY});
                    }
                }
            }
        }
        return -1;
    }
}