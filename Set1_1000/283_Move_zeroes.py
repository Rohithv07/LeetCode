class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        for element in range(len(nums)):
            if nums[element] != 0:
                nums[i], nums[element] = nums[element], nums[i]
                i = i + 1
        
