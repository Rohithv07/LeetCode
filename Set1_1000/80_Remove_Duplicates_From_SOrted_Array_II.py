class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for element in nums[::-1]:
            if nums.count(element) > 2:
                nums.remove(element)
        
        return len(nums)



class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for element in nums[::-1]:
            if nums.count(element) > 2:
                nums.remove(element)
        
        return len(nums)
