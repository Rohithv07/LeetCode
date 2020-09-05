// A simple point to directly get the sum of primary and secondary sum.

sum += mat[i][i] + mat[i][n - 1 - i];


class Solution {
    public int diagonalSum(int[][] mat) {
        if (mat.length == 0)
            return 0;
        if (mat.length == 1)
            return mat[0][0];
        int primarySum = 0;
        int secondarySum = 0;
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat.length; j++) {
                if (i == j)
                    primarySum += mat[i][j];
                if ((i+j) == (mat.length-1))
                    secondarySum += mat[i][j];
            }
        }
        if (mat.length % 2 == 0)
            return primarySum + secondarySum;
        int mid = (mat.length-1) / 2;
        int intermediateSum = mat[mid][mid];
        return primarySum + secondarySum - intermediateSum;
    }
}
