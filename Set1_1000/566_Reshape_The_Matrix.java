class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length == 0)
            return new int [][] {};
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != r * c) {
            return mat;
        }
        int [][] result = new int [r][c];
        int currentResultRow = 0;
        int currentResultCol = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (currentResultCol >= c) {
                    currentResultRow += 1;
                    currentResultCol = 0;
                    result[currentResultRow][currentResultCol] = mat[i][j];
                }
                else {
                    result[currentResultRow][currentResultCol] = mat[i][j];
                }
                currentResultCol++;
            }
        }
        return result;
    }
}

/*
Another approach

public int[][] matrixReshape(int[][] nums, int r, int c) {
    int n = nums.length, m = nums[0].length;
    if (r*c != n*m) return nums;
    int[][] res = new int[r][c];
    for (int i=0;i<r*c;i++) 
        res[i/c][i%c] = nums[i/m][i%m];
    return res;
}
*/
