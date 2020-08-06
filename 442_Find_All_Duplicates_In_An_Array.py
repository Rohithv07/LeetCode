class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        li = []
        
        for elements, counter in Counter(nums).items():
            if counter > 1:
                li.append(elements)
                
        return li
        
