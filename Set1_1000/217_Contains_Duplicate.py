class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
   #     if len(nums) == 0:
   #         return False
   #     dict = {}
   #     for elements in nums:
   #         if elements in dict.keys():
   #             return True
   #         else:
   #             dict[elements] = True
        
   #     return False
    
        return len(set(nums)) != len(nums)
            
