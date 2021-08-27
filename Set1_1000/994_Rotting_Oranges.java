class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if (grid[i][j] == 1)
                    freshCount ++;
            }
        }
        int time = 0;
        int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty() && freshCount > 0){
            time ++;
            int size = queue.size();
            while(size > 0){
                int [] xy = queue.poll();
                for(int [] d : directions){
                    int x = xy[0] + d[0];
                    int y = xy[1] + d[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    queue.add(new int []{x, y});
                    grid[x][y] = 2;
                    freshCount --;
                } 
                size --;
            }
        }
        return freshCount == 0 ? time : -1;
        
    }
}
