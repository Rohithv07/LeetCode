// refer1: https://leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
// refer2: https://leetcode.com/problems/matrix-block-sum/discuss/477041/Java-Prefix-sum-with-Picture-explain-Clean-code-O(m*n)


class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;
        int [][] sum = new int [row+1][col+1];
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                sum[i][j] = mat[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            } 
        }
        int [][] answer = new int [row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int row1 = Math.max(0, i-K);
                int col1 = Math.max(0, j-K);
                int row2 = Math.min(row-1, i+K);
                int col2 = Math.min(col-1, j+K);
                row1 += 1;
                col1 += 1;
                row2 += 1;
                col2 += 1;
                answer[i][j] = sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
            }
        }
        return answer;
    }
}
