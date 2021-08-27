class Solution {
    public boolean stoneGame(int[] piles) {
        // this is an accepted solution, just:return true;
        int n = piles.length;
        int [][] dp = new int [n][n];
        for (int i=0; i<n; i++)
            dp[i][i] = piles[i];
        for (int i=1; i<n; i++) {
            for (int j=0; j<n-i; j++) {
                dp[j][j+i] = Math.max(piles[j] - dp[j+1][i+j], piles[j+i] - dp[j][j+i-1]);
            } 
        }
        return dp[0][n-1] > 0;
    }
}


// using memoisation

class Solution {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int [] sum = new int [length];
        int [][] cache = new int [length][length];
        sum[0] = piles[0];
        for (int i=1; i<length; i++) {
            sum[i] = sum[i - 1] + piles[i];
        }
        int alex = findPoint(piles, sum, cache, 0, length - 1);
        return alex > sum[length - 1] - alex;
    }
    
    public int findPoint(int [] piles, int [] sum, int [][] cache, int start, int end) {
        if (start > end)
            return 0;
        if (cache[start][end] != 0)
            return cache[start][end];
        int currentSum = sum[end] - sum[start] + piles[start];
        int point = currentSum - Math.min(findPoint(piles, sum, cache, start + 1, end), findPoint(piles, sum, cache, start, end - 1));
        cache[start][end] = point;
        return point;
    }
}
