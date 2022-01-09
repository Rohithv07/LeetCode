class Solution {
    public boolean checkValid(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i=0; i<row; i++) {
            int rowWiseXor = 0;
            int colWiseXor = 0;
            for (int j=0; j<col; j++) {
                rowWiseXor ^= (matrix[i][j]) ^ (j + 1);
                colWiseXor ^= (matrix[j][i]) ^ (j + 1);
            }
            if (rowWiseXor != 0 || colWiseXor != 0) {
                return false;
            }
        }
        return true;
    }
}