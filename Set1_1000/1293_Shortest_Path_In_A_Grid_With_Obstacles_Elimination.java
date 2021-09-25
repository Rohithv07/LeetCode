class Solution {
    public int shortestPath(int[][] grid, int k) {
        int [][] directions = new int [][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        // 3d array for keeping track of visired
        int row = grid.length;
        int col = grid[0].length;
        boolean [][][] visited = new boolean[row][col][row*col]; // the last [] denotes number of obstacles removed
        // for bfs we make use of a queue of type Node
        Queue<Node> queue = new LinkedList<>();
        // we start from 0,0 with distance 0 and 0 number of obstacles removed initially and this is added to the queue
        queue.offer(new Node(0, 0, 0, 0));
        // mark in the visited as true
        visited[0][0][0] = true;
        // do the bfs
        while (!queue.isEmpty()) {
                Node current = queue.poll();
                int i = current.x;
                int j = current.y;
                int dist = current.distance;
                int rem = current.removed;
                // initial check if we reached the end or not
                if (i == row-1 && j == col-1)
                    return dist;
                // we can make 4 different movements
                for (int d=0; d<4; d++) {
                    int nextX = i + directions[d][0];
                    int nextY = j + directions[d][1];
                    // the boundary conditons true or not
                    if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                        // remove the obstacle
                        int newRemoved = rem + grid[nextX][nextY];
                        if (k >= newRemoved && !visited[nextX][nextY][newRemoved]) {
                            // update the visited
                            visited[nextX][nextY][newRemoved] = true;
                            // add the elements to the queue
                            queue.offer(new Node(nextX, nextY, dist+1, newRemoved));
                        }
                    }
                }
            }
        // if we can't make any progress
        return -1;
        
    }
}

// we can make use of our own class for the x coordinate, y coordinate, number of obstacles removed, and the distance
public class Node {
    int x;
    int y;
    int distance;
    int removed;
    Node(int x, int y, int distance, int removed) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.removed = removed;
    }
}



// another method


class Solution {
    
    private static final int [][] directions = new int [][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (k >= row + col - 2) {
            return row + col - 2;
        }
        return bfs(grid, k, row, col);
    }
    
    private int bfs(int [][] grid, int k, int row, int col) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][][] visited = new boolean [row][col][k + 1];
        queue.offer(new int []{0, 0, k});
        int shortestDistance = 0;
        visited[0][0][k] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] currentCell = queue.poll();
                int x = currentCell[0];
                int y = currentCell[1];
                int obstacle = currentCell[2];
                if (x == row - 1 && y == col - 1) {
                    return shortestDistance;
                }
                for (int [] dir : directions) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                        continue;
                    }
                    int remaining = obstacle - grid[newX][newY];
                    if (remaining >= 0 && !visited[newX][newY][remaining]) {
                        queue.offer(new int [] {newX, newY, remaining});
                        visited[newX][newY][remaining] = true;   
                    }
                }
            }
            shortestDistance += 1;
        }
        return -1;
    }
}
