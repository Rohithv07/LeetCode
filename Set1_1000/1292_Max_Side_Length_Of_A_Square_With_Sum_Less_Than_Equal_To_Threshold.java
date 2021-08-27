class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length;
        int col = mat[0].length; 
        int [][] prefixSum = new int [row+1][col+1];
        int max = 0;
        // find the prefix sum
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                prefixSum[i+1][j+1] = prefixSum[i+1][j] + prefixSum[i][j+1] - prefixSum[i][j] + mat[i][j];
                if (i - max >= 0 && j - max >= 0 && prefixSum[i+1][j+1]-prefixSum[i-max][j+1]-prefixSum[i+1][j-max]+prefixSum[i-max][j-max] <= threshold)
                    max += 1;
            }
        }
        return max;
    }
}
