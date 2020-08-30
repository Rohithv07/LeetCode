class Solution:
    def findLHS(self, nums: List[int]) -> int:
        dictionary = {}
        result = 0
        for element in nums:
            if element not in dictionary:
                dictionary[element] = 1
            else:
                dictionary[element] += 1
        for key in dictionary:
            if key+1 in dictionary.keys():
                result = max(result, dictionary[key]+dictionary[key+1])
        return result
