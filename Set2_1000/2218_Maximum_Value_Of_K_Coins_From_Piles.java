class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int pilesLength = piles.size();
        Integer [][] dp = new Integer[pilesLength + 1][k + 1];
        return knapsackLogic(dp, 0, piles, k, pilesLength);
    }
    
    public int knapsackLogic(Integer [][] dp, int index, List<List<Integer>> piles, int k, int pilesLength) {
        if (index >= pilesLength) {
            return 0;
        }
        if (dp[index][k] != null) {
            return dp[index][k];
        }
        int max = 0;
        int sum = 0;
        // here we are not taking a parituclar pile, we skip it
        max = Math.max(max, knapsackLogic(dp, index + 1, piles, k, pilesLength));
        // otherwise we can take some prefix of piles and cosnider it for our answer
        for (int i = 0; i < piles.get(index).size(); i++) {
            sum += piles.get(index).get(i);
            if (k - i - 1 >= 0) {
                max = Math.max(max, sum + knapsackLogic(dp, index + 1, piles, k - i - 1, pilesLength));
            }
        }
        return dp[index][k] = max;
    }
}