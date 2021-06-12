class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i=0; i<4; i++) {
            if (Arrays.deepEquals(mat, target))
                return true;
            rotate(mat);
        }
        return false;
    }
    
    public void rotate(int [][] mat) {
        int length = mat.length;
        for (int i=0, j=length - 1; i<j; i++, j--) {
            int [] temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;
        }
        for (int r=0; r<mat.length; r++) {
            for (int c=r+1; c<mat.length; c++) {
                int temp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = temp;
            }
        }
    }
}
