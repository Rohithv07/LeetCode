class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_without_stock = 0
        max_with_stock = -10000
        
        for elements in prices:
            max_with_stock = max(max_with_stock, max_without_stock - elements)
            max_without_stock = max(max_without_stock, max_with_stock + elements)
            
        return max_without_stock
