class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        int row = matrix.length;
        int column = matrix[0].length;
        for (int c=0; c<column; c++){
            if (matrix[0][c] == 0)
                firstRow = true;
        }
        for (int r=0; r<row; r++){
            for (int c=0; c<column; c++){
                if (matrix[r][c] == 0)
                    matrix[0][c] = 0;
            }
        }
        for (int r=1; r<row; r++){
            boolean rowZero = false;
            for (int c=0; c<column; c++){
                if (matrix[r][c] == 0)
                    rowZero = true;
            }
            for (int c=0; c<column; c++){
                if (rowZero || matrix[0][c] == 0)
                    matrix[r][c] = 0;
            }
        }
        for (int c=0; c<column; c++){
            if (firstRow)
                matrix[0][c] = 0;
        }
    }
}
