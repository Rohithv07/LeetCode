class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int previousSell = 0;
        int buy = Integer.MIN_VALUE;
        int previousBuy;
        for (int price: prices) {
            previousBuy = buy;
            buy = Math.max(previousSell-price, previousBuy);
            previousSell = sell;
            sell = Math.max(previousBuy+price, previousSell);
        }
        return sell;
    }
}
