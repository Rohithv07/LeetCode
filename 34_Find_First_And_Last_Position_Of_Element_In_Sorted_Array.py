class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        result = [-1, -1]
        try:
            result[0] = nums.index(target)
            nums.reverse()
            result[1] = len(nums) - nums.index(target) -1
        except:
            pass
        
        return result
