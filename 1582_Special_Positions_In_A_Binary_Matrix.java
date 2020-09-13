class Solution {
    public int numSpecial(int[][] mat) {
        int oneCount = 0;
        int flag = 0;
        int row = mat.length;
        int column = mat[0].length;
        int [] rowMat = new int[row];
        int [] colMat = new int[column];
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (mat[i][j] == 1) {
                    rowMat[i] += 1;
                    colMat[j] += 1;
                }
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (mat[i][j] == 1 && rowMat[i] == 1 && colMat[j] == 1)
                    oneCount += 1;
            }
        }
        return oneCount;
    }
}
