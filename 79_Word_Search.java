class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word.length() == 0)
            return false;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == word.charAt(0) && dfsHelper(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    public boolean dfsHelper(char [][] board, int row, int column, int count, String word){
        if (count == word.length())
            return true;
        if (row<0 || column<0 || row >= board.length || column >= board[row].length || board[row][column] != word.charAt(count))
            return false;
        char temp = board[row][column];
        board[row][column] = ' ';
        boolean finalResult = dfsHelper(board, row+1, column, count + 1, word) ||
                              dfsHelper(board, row-1, column, count + 1, word) ||
                              dfsHelper(board, row, column-1, count + 1, word) ||
                              dfsHelper(board, row, column+1, count + 1, word);
        board[row][column] = temp;
        return finalResult;
    }
}
