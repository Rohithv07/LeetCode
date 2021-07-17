class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int [][] dp = new int [length1 + 1][length2 + 1];
        for (int i=0; i<=length1; i++) {
            for (int j=0; j<=length2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}