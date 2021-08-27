class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        s = [0, 0]
        for i, num in enumerate(nums[1:]):
            s[i%2] += num
        fair = int(s[0] == s[1])
        for i, num in enumerate(nums[:-1]):
            s[i%2] += num - nums[i + 1]
            fair += s[0] == s[1]
        return fair
    
    
"""
s[0] is sum of even indices, s[1] is sum of odd indices
fair is the count of fair arrays
First you start with removing the 0th element. And you decide whether that array is fair. Then for the 1st element through the last element, you don't have to add everything up again; you can just change the 2 elements (put the previously removed element back in, and removed the new element.)
"""
