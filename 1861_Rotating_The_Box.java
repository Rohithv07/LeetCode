class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        char [][] result = new char [col][row];
        int empty = 0;
        for (char [] r : box) {
            empty = col - 1;
            for (int i=col - 1; i>=0; i--) {
                if (r[i] == '*') {
                    empty = i - 1;
                }
                if (r[i] == '#') {
                    r[i] = '.';
                    r[empty] = '#';
                    empty -= 1;
                }
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=col-1; j>=0; j--) {
                result[j][row - i - 1] = box[i][j];
            }
        }
        return result;
    }
}
