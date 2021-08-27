class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] dp = new int [row][col];
        int result = Integer.MIN_VALUE;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int currentArea = matrix[i][j];
                if (i - 1 >= 0) {
                    currentArea += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    currentArea += dp[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    currentArea -= dp[i - 1][j - 1];
                }
                dp[i][j] = currentArea;
            }
        }
        return findAreaLessThanK(dp, result, k, row, col);
    }
    
    public int findAreaLessThanK(int [][] dp, int result, int k, int row, int col) {
        for (int i=0; i<row; i++) {
            for (int j=i; j<row; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int c=0; c<col; c++) {
                    int area = dp[j][c];
                    if (i - 1 >= 0) {
                        area -= dp[i - 1][c];
                    }
                    Integer ceiling = set.ceiling(area - k); // least element greater than equal to given element
                    if (ceiling != null) {
                        result = Math.max(result, area - ceiling);
                    }
                    set.add(area);
                }
            }
        }
        return result;
    }
}
