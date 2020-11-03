class Solution {
    public String tictactoe(int[][] moves) {
        int [] aRow = new int [3];
        int [] aCol = new int [3];
        int [] bRow = new int [3];
        int [] bCol = new int [3];
        int aD1 = 0;
        int aD2 = 0;
        int bD1 = 0;
        int bD2 = 0;
        int row = moves.length;
        for (int i=0; i<row; i++) {
                int rowMove = moves[i][0];
                int colMove = moves[i][1];
                if (i % 2 == 1) {
                    // player b
                    if (++bRow[rowMove] == 3 || ++bCol[colMove] == 3 || rowMove == colMove && ++bD1 == 3 || rowMove+colMove == 2 && ++bD2 == 3)
                        return "B";
                }
                    else {
                        if (++aRow[rowMove] == 3 || ++aCol[colMove] == 3 || rowMove == colMove && ++aD1 == 3 || rowMove+colMove == 2 && ++aD2 == 3)
                            return "A";
                    }
                }
        return row == 9 ? "Draw" : "Pending";
    }
}
