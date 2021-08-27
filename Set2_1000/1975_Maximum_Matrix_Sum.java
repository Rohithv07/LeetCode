// why we multiply by 2 :
// we have to minus the min value twice as we have stored the total absolute sum so first we have minus the min value we add the negative min value therefore we have to minus the twice the min value
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // even number of negative number -> abs(sum)
        // odd number of negative number -> sum - 2 * min
        if (matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        long countNegativeNumbers = 0l;
        long totalSum = 0l;
        int minimumInMatrix = Integer.MAX_VALUE;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] < 0) {
                    countNegativeNumbers += 1;
                    matrix[i][j] *= -1;
                }
                totalSum += Math.abs(matrix[i][j]);
                minimumInMatrix = Math.min(minimumInMatrix, matrix[i][j]);
            }
        }
        return countNegativeNumbers % 2 == 1 ? totalSum - 2 * minimumInMatrix : totalSum;
        
    }
}