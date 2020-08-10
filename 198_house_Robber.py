class Solution:
    def rob(self, nums: List[int]) -> int:
        a, b = 0, 0
        for item in nums:
            a, b = b, max(a+item, b)
            
        return b
