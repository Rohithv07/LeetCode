class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int [][] result = new int [row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.add(new int []{i, j});
                }
                else {
                    result[i][j] = -1;
                }
            }
        }
        int [][] directions = new int [][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || result[newX][newY] != -1)
                    continue;
                result[newX][newY] = result[x][y] + 1;
                queue.add(new int [] {newX, newY});
            }
        }
        return result;
    }
}
