class Solution {
    
    private final int [][] directions = new int [][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int[][] findFarmland(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        List<int[]> possibleResult = new ArrayList<>();
        boolean [][] visited = new boolean [row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    int [] coordinate = new int []{i, j, 0, 0};
                    queue.add(new int []{i, j});
                    bfs(land, coordinate, visited, i, j, queue);
                    possibleResult.add(coordinate);
                }
            }
        }
        return possibleResult.toArray(new int [possibleResult.size()][4]);
    }
    
    public void bfs(int [][] land, int [] coordinate, boolean [][] visited, int i, int j, Queue<int[]>queue) {
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            for (int [] dir : directions) {
                int newX = current[0] + dir[0];
                int newY = current[1] + dir[1];
                if (newX < 0 || newX >= land.length || newY < 0 || newY >= land[0].length || visited[newX][newY] || land[newX][newY] == 0) {
                    continue;
                }
                visited[newX][newY] = true;
                queue.add(new int []{newX, newY});
            }
            coordinate[2] = Math.max(coordinate[2], current[0]);
            coordinate[3] = Math.max(coordinate[3], current[1]);
        }
    }
}