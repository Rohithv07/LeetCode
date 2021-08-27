class Solution {
    public int uniquePaths(int m, int n) {
        int [][] totalCount = new int [m][n];
        for (int i=0; i<m; i++)
            totalCount[i][0] = 1;
        for (int i=0; i<n; i++) 
            totalCount[0][i] = 1;
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                totalCount[i][j] = totalCount[i-1][j] + totalCount[i][j-1];
            }
        }
        return totalCount[m-1][n-1];
    }
}
