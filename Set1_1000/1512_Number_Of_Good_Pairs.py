class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        """
        Solution 1:
        if len(nums) == 0:
            return 0
        dictionary = {}
        total = 0
        for element in nums:
            if element in dictionary:
                dictionary[element] += 1
            else:
                dictionary[element] = 1
        for value in dictionary.values():
            if value > 1:
                total += value * (value - 1) // 2
        return total
        """
        
        # Solution 2
        if len(nums) == 0:
            return 0
        count = 0
        dictionary = {}
        for element in nums:
            if element in dictionary:
                count += dictionary[element]
                dictionary[element] += 1
            else:
                dictionary[element] = 1
        return count
                
        
