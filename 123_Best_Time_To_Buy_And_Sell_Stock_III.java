class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for (int i=0; i<prices.length; i++){
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSell = Math.max(firstSell, firstBuy+prices[i]);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            secondSell = Math.max(secondSell, secondBuy+prices[i]);
        }
        return secondSell;
    }
}
