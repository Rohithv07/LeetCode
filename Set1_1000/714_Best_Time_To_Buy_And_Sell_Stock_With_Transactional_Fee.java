class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i=1; i<prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}

/*
->Only 1 share of the stock can be bought or sold;
->A stock can be bought or sold for multiple times in one day, but it has to be sold before being bought again;
->The service fee is only charged when stock is sold;
->Cash(i): the cash in hand, if you are not holding the stock at the end of day(i):
->You might be not holding the stock at the end of day(i-1), and do nothing in day(i): a = cash(i-1); or
->You might be holding the stock at the end of day(i-1), and sell it at the end of day(i):
b = hold(i-1) + prices[i] - fee;
->Choose the greatest one as the value of cash(i) to get the greater potential profit:
cash(i) = max(a, b) = max(cash(i-1), hold(i-1) + prices[i] - fee);
->Hold(i): the cash in hand, if you are holding the stock at the end of day(i):
->You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
->You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash(i-1) - prices[i]; or
->You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of day(i):
c = (hold(i-1) + prices[i] - fee) - prices[i];
->Choose the greatest one as the value of hold(i) to get the greater potential profit:
hold(i) = max(a,b,c)
->Because max(b, c) = max(cash(i-1), hold(i-1) + prices[i] - fee) - prices[i] = cash(i) - prices[i],
so hold(i) = max(hold(i-1), cash(i) - prices[i]);
->There is another way to calculate hold(i), which is more straight forward:
->You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
->You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash(i-1) - prices[i]; or
->You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of day(i):
c = (hold(i-1) + prices[i] - fee) - prices[i] = hold(i-1) - fee;
->Obviously, a > c, so max(a, c) = a, hold(i) = max(a, b, c) = max(a, b) = max(hold(i-1), cash(i-1) - prices[i])
->The target is to find the maximum profit at the end of day(N): cash(N);

