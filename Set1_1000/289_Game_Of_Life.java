class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int lives = livingNeighbours(board, m, n, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3)
                    board[i][j] = 3;
                if (board[i][j] == 0 && lives == 3)
                    board[i][j] = 2;
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    public int livingNeighbours(int [][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x=Math.max(i-1, 0); x<=Math.min(i+1, m-1); x++) {
            for (int y=Math.max(j-1, 0); y<=Math.min(j+1, n-1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}


// not dfs or bfs but logic more understandable

class Solution {
    
    private final int [][] directions = new int [][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1},
                                                      {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int live = 0;
                for (int [] dir : directions) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (x >= 0 && y >= 0 && x < row && y < col && Math.abs(board[x][y]) == 1) {
                        live++;
                    }
                }
                if (board[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = -1;
                    }
                }
                else {
                    if (live == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        // change all 2 to 1 and -1 to 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } 
                else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}