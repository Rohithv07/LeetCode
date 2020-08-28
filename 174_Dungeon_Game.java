class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int [][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for (int i=0; i<=dungeon.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[row-1][col] = 1;
        dp[row][col-1] = 1;
        for (int i=row-1; i>=0; i--) {
            for (int j=col-1; j>=0; j--) {
                int minimumHealth = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                if (minimumHealth <= 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = minimumHealth;
            }
        }
        return dp[0][0];
    }
}
