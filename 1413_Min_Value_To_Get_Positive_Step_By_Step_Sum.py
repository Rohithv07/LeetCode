class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        pSum = 0
        minSum = 0;
        for num in nums:
            pSum += num
            minSum = min(pSum, minSum)
        return 1 - minSum
