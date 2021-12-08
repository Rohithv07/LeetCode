// ref video : https://youtu.be/i05Ju7AftcM

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(result, board, n, 0);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char [][] board, int n, int pos) {
        if (pos == n) {
            List<String> current = new ArrayList<>();
            for (char [] row : board) {
                String currentRow = new String(row);
                current.add(currentRow);
            }
            result.add(new ArrayList<>(current));
            return;
        }
        // check from every row current col which is pos
        for (int i=0; i<n; i++) {
            if (canWePlaceQueen(board, i, pos, n)) {
                board[i][pos] = 'Q';
                backtrack(result, board, n, pos + 1);
                board[i][pos] = '.';
            }
        }
    }
    
    private boolean canWePlaceQueen(char [][] board, int row, int col, int n) {
        int copyRow = row;
        int copyCol = col;
        // left upper diagonal check for queen
        while (copyRow >= 0 && copyCol >= 0) {
            if (board[copyRow][copyCol] == 'Q') {
                return false;
            }
            copyRow--;
            copyCol--;
        }
        // left part of the current row check for queen
        copyRow = row;
        copyCol = col;
        while (copyCol >= 0) {
            if (board[copyRow][copyCol] == 'Q') {
                return false;
            }
            copyCol--;
        }
        // left down diagonal check for queen
        copyRow = row;
        copyCol = col;
        while (copyRow < n && copyCol >= 0) {
            if (board[copyRow][copyCol] == 'Q') {
                return false;
            }
            copyRow++;
            copyCol--;
        }
        return true;
    }
}
















class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // initialize our current board with '.'
        char [][] current = new char[n][n];
        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) 
                current[i][j] = '.';
        helperFunction(result, current, n, 0);
        System.out.println(result.size());
        return result;
    }
    public void helperFunction(List<List<String>> result, char [][] current, int n, int start) {
        // 1. Our goal
        if (start == n) {
            List<String> finalAdd = new ArrayList<>();
            for (int i=0; i<current.length; i++) {
                String s = new String(current[i]);
                finalAdd.add(s);
            }
            result.add((finalAdd));
            return;
        }
        for (int i=0; i<n; i++) {
                // 2. Our choice
                if (isValid(current, i, start)) {
                    current[i][start] = 'Q';
                    // 3. Our constraint
                    helperFunction(result, current, n, start+1);
                }
                // 4. Undo our choice
                current[i][start] = '.';
        }
    }
    public boolean isValid(char [][] current, int x, int y) {
        for (int i=0; i<current.length; i++) {
            for (int j=0; j<current[i].length; j++) {
                if (current[i][j] == 'Q' && (x+j == y+i || x+y == i+j || x == i))
                    return false;
            }
        }
        return true;
    }
}
