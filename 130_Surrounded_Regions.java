class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 3 || board[0].length < 3)
            return;
        int row = board.length;
        int col = board[0].length;
        // left most, right most, top most and downmost
        for (int i=0; i<row; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][col - 1] == 'O')
                dfs(board, i, col - 1);
        }
        for (int j=1; j<col-1; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[row-1][j] == 'O')
                dfs(board, row - 1, j);
        }
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '&')
                    board[i][j] = 'O';
            }
        }
    }
    public void dfs(char [][] board, int i, int j) {
        if (i < 0 || i > board.length-1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O')
            return;
        board[i][j] = '&';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
