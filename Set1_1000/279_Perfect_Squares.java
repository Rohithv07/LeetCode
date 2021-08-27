// max number of perfect square to the sum == N will be N

class Solution {
    public int numSquares(int n) {
        if (n <= 3)
            return n;
        int answer = Integer.MAX_VALUE;
        // recursive approach which gets time limit exceeded, so dp is required
        /*
        for (int i=1; i*i<=n; i++) {
            answer = Math.min(answer, 1+numSquares(n - i*i));
        }
        */
        int [] dp = new int [n+1];
        for (int i=0; i<=n; i++) {  // O(n)
            dp[i] = i; // the maximum number of perfect square to make the sum
            for (int j=1; j*j<=i; j++) //O(sqrt(n))
            dp[i] = Math.min(dp[i], 1+dp[i - j*j]);
        }
        return dp[n];
    }
}


// reference : https://www.youtube.com/watch?v=1xfx6M_GqFk
