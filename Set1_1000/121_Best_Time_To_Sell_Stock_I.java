class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        
        int min_buy = prices[0], max_buy = 0;
        for (int i =0; i < prices.length; i++){
            min_buy = Math.min(min_buy, prices[i]);
            max_buy = Math.max(max_buy, prices[i] - min_buy);
        }
        return max_buy;
    }
}
