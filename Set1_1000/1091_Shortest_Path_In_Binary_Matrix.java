class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1)
            return -1;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int [] {0, 0});
        boolean [][] visited = new boolean[row][col];
        visited[0][0] = true;
        int count = 0;
        int [][] directions = new int [][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x == row -1 && y == col - 1)
                    return count + 1;
                for (int [] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY] || grid[newX][newY] == 1)
                        continue;
                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int [] {newX, newY});
                    }
                }
            }
            count += 1;
        }
        return -1;
    }
}
