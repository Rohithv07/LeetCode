class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        if len(left) == 0:
            totalDistanceLeft = 0
        else:
            totalDistanceLeft = max(left)
        if len(right) == 0:
            totalDistanceRight = n
        else:
            totalDistanceRight = min(right)
        return max(totalDistanceLeft-0, n-totalDistanceRight)
