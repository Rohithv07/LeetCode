class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
         n = len(nums)
        nums.sort(reverse = True)
        
        a = max(nums[0] * nums[1] * nums[2] , nums[0] * nums[n-1] * nums[n-2])
        
        return a
