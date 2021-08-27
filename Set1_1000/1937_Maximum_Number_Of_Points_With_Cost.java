class Solution {
    public long maxPoints(int[][] points) {
        if (points == null || points.length == 0)
            return 0l;
        int row = points.length;
        int col = points[0].length;
        long [] dp = new long [col];
        long result = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                dp[j] += points[i][j];
            }
            for (int j=1; j<col; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j=col-2; j>=0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        for (int i=0; i<col; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
// class Solution {
// public long maxPoints(int[][] points) {
//         long ans = 0;
//         int m = points.length, n = points[0].length;
//         long []dp = new long[n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 dp[j] += points[i][j];
//             }
//             for(int j=1;j<n;j++){
//                 dp[j] = Math.max(dp[j], dp[j-1] - 1);
//             }
//             for(int j=n-2;j>=0;j--){
//                 dp[j] = Math.max(dp[j], dp[j+1] - 1);
//             }
//         }
//         for(int i=0;i<n;i++){
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }
// }