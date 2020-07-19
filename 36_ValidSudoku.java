class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> visited = new HashSet();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char current = board[i][j];
                if(current != '.'){
                    if(!visited.add(current+"Row"+i) || !visited.add(current+"Column"+j) ||
                      !visited.add(current+"Boxes"+i/3+"-"+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
