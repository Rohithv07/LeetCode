class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums
        
        middleLimit = len(nums) / 2
        nums.sort()
        nums[int(middleLimit)]
        
