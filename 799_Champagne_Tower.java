class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [][] matrix = new double[101][101]; // given constrains from [0, 99] inclusive
        matrix[0][0] = poured;
        for (int i=0; i<=query_row; i++) {
            for (int j=0; j<=i; j++) {
                double overflow = (matrix[i][j] - 1.0) / 2.0;
                if (overflow > 0) {
                    matrix[i+1][j] += overflow;
                    matrix[i+1][j+1] += overflow;
                }
            }
        }
        return Math.min(1, matrix[query_row][query_glass]);
    }
}
