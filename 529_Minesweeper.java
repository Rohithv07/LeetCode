class Solution {
    
    private int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        // bfs
        int x = click[0];
        int y = click[1];
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int [] {x, y});
        // int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            x = current[0];
            y = current[1];
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } 
            else {
                int count = 0;
                for (int [] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length)
                        continue;
                    if (board[newX][newY] == 'M' || board[newX][newY] == 'X')
                        count += 1;
                }
                if (count > 0)
                    board[x][y] = (char) (count + '0');
                else {
                    board[x][y] = 'B';
                    for (int [] dir : directions) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length)
                            continue;
                        if (board[newX][newY] == 'E') {
                            queue.add(new int []{newX, newY});
                            board[newX][newY] = 'B';
                        } 
                    }
                }
            }
        }
        return board;
        
        
        // dfs
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }
    
    public void dfs(char [][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') 
            return;
        int numberOfBombs = getBombs(board, x, y);
        if (numberOfBombs != 0) {
            board[x][y] = (char)(numberOfBombs + '0');
        }
        else {
            board[x][y] = 'B';
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                dfs(board, newX, newY);
            }
        }
    }
    
    public int getBombs(char [][] board, int x, int y) {
        int count = 0;
        for (int [] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length)
                continue;
            if (board[newX][newY] == 'M' || board[newX][newY] == 'X')
                count += 1;
        }
        return count;
    }
}
