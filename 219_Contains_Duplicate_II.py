class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dict = {}
        for i, j in enumerate(nums):
            if j in dict and i - dict[j] <= k:
                return True
            dict[j] = i
        
        return False
