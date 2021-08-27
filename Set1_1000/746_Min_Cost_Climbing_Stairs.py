class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        length = len(cost)
        dynamic = [0] * (length + 1)
        
        for i in range(2, length + 1):
            dynamic[i] = min(dynamic[i - 1] + cost[i - 1], dynamic[i - 2] + cost[i -2])
        
        return dynamic[length]
