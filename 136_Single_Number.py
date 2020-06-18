class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # Solution 1:
        #for items in nums:
            #if nums.count(items) == 1:
                #return items
            
        # Solution 2 Using XOR:
        a = 0
        for i in nums:
            a ^= i
        return a
        
