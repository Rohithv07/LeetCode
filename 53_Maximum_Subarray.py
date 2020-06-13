class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maximumSum = min(nums)
        sumFactor = 0
        
        for items in nums:
            sumFactor = sumFactor + items
            if sumFactor < items:
                sumFactor = items
            if maximumSum < sumFactor:
                maximumSum = sumFactor
                
        return maximumSum
