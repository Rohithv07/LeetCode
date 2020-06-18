class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1
        
        i = 0
        for j in range(1, len(nums)):
            if(nums[i] != nums[j]):
                i += 1
                nums[i] = nums[j]
        return i + 1
