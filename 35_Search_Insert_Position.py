class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        max = nums[0]
        for i in range(len(nums)):
            try:
                if target > nums[i]:
                    max = nums[i+1]
                elif target < nums[i]:
                    return i
            except(IndexError):
                return i+1