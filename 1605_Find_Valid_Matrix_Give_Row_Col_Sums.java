/*
For each result value at A[i][j],
we greedily take the min(row[i], col[j]).

Then we update the row sum and col sum:
row[i] -= A[i][j]
col[j] -= A[i][j]
*/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length;
        int c = colSum.length;
        int [][] result = new int [r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                result[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= result[i][j];
                colSum[j] -= result[i][j];
            }
        }
        return result;
    }
}
