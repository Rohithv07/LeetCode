class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 0:
            return 0
        
        min_buy = prices[0]
        max_buy = 0
        
        for elements in prices:
            min_buy = min(min_buy, elements)
            max_buy = max(max_buy, elements - min_buy)
            
        return max_buy
    
