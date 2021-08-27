class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (board == null || board.length == 0)
            return false;
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
        char oppositeColor = color == 'W' ? 'B' : 'W';
        for (int i=0; i<8; i++) {
            int x = rMove;
            int y = cMove;
            int count = 1;
            x += directions[i][0];
            y += directions[i][1];
            while (x < 8 && y < 8 && x >= 0 && y >= 0 && board[x][y] != '.') {
                if (count != 1 && board[x][y] == color)
                    return true;
                if (board[x][y] != oppositeColor)
                    break;
                x += directions[i][0];
                y += directions[i][1];
                count += 1;
            }
        }
        return false;
    }
}