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
