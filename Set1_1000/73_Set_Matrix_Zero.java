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



// using extra space

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int [] trackRowZero = new int [row];
        Arrays.fill(trackRowZero, -1);
        int [] trackColZero = new int [col];
        Arrays.fill(trackColZero, -1);
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0) {
                    trackRowZero[i] = 0;
                    trackColZero[j] = 0;
                }
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (trackRowZero[i] == 0 || trackColZero[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


// using constant space

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int col0 = 1;
        // make the first row and first col as a dummy array as we did before
        for (int i=0; i<row; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j=1; j<col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // now start from bottom right to top left
        for (int i=row-1; i>=0; i--) {
            for (int j=col-1; j>=1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}
