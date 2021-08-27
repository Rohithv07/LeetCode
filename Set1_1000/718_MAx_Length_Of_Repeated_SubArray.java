/* My thought process
So this is a pattern of Dynamic Programming Problem. We create a 2d dp array and do a bottom up approach.
Wheneevr we see A[i] = B[j], then we update dp[i][j] = dp[i+1][j+1] + 1.

Maximum value from the dp array is the answer for our problem.


*/


class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null)
            return 0;
        int [][] dp = new int [A.length+1][B.length+1];
        int answer = 0;
        for (int i=A.length-1; i>=0; i--) {
            for (int j=B.length-1; j>=0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer;
    }
}
