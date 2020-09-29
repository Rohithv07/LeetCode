// Refer : https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720280/Java-histogram-count

class Solution {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int [] height = new int [col];
        int count = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                for (int k=j, min = height[j]; k>=0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    count += min;
                }
            }
        }
        return count;
    }
}
