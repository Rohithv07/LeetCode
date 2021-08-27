class Solution {
    public int change(int amount, int[] coins) {
        
        int [] dp = new int [amount+1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i=coin; i<=amount; i++)
                dp[i] += dp[i-coin];
        }
        return dp[amount];
        
        
        // bottom up knapsack idea
        int length = coins.length;
        int [][] dp = new int [length+1][amount+1];
        dp[0][0] = 1;
        for (int i=1; i<=length; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - coins[i-1] >= 0)
                    dp[i][j] += dp[i][j - coins[i-1]];
            }
        }
        return dp[length][amount];
    }
}


// using memoization - unbounded knapsack
class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length][amount + 1];
        for (int i=0; i<coins.length; i++) {
            for (int j=0; j<amount+1; j++) {
                dp[i][j] = -1;
            }
        }
        return backtrack(dp, amount, coins, 0);
    }
    
    public int backtrack(int [][] dp, int amount, int coins[], int index) {
        if (amount == 0)
            return 1;
        if (amount < 0 || index == coins.length)
            return 0;
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        // use index coin or do not use index coin like knapsack where we have infinite number of items
        int answer = 0;
        answer += backtrack(dp, amount, coins, index+1); // skipped
        answer += backtrack(dp, amount - coins[index], coins, index); // here we donot increase index as same item can be used many times
        dp[index][amount] = answer;
        return dp[index][amount];
        
    }
}


// same idea

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount < 0)
            return 0;
        int [] dp = new int [amount + 1];
        dp[0] = 1;
        for (int i=0; i<coins.length; i++) {
            for (int j=1; j<=amount; j++) {
                //dp[j] = dp[j - 1];
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}