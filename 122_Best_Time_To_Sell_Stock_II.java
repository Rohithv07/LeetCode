class Solution {
    public int maxProfit(int[] prices) {
        int max_without_stock = 0, max_with_stock = -100000;
        for(int i = 0; i < prices.length; i++){
            max_with_stock = Math.max(max_with_stock, max_without_stock - prices[i]);
            max_without_stock = Math.max(max_without_stock, max_with_stock + prices[i]);
        }
        return max_without_stock;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // valley peak approach
        // if the current element is greater than previous element, we add the profit assuming we sell on current element and buy on previous element
        // else we just skip it
        if (prices == null || prices.length <= 1)
            return 0;
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
