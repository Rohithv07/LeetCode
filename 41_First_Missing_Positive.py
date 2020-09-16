"""
My thought process:
So my initial thought was to use a iterate variable from 1 to len(nums) + 1, if that value is not in array, then just return it. But then I encoutered error when there is negative element, single element etc.
So we can just find the maximum from the given array and the value we want to return will not exceed maximum + 1
So we can again iterate as discusses earlier and return the value which is not present in array. But again , there can be eror if there is only negative number array. So we have to return the smallest positive integer. SO As I told we want to find the maximum from the array and if the maximum is a negative number then we can just make the maximum as 1. This is the thing we have to keep in mind. Now just iterate from 1 to maximum+2(excluding) and print the value of i if its not in the nums array. Thats the problem.
"""


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 1
        if nums:
            maximumValue = max(nums)
        else:
            maximumValue = 1
        if maximumValue < 0:
            maximumValue = 1
        for i in range(1, maximumValue+2):
            if i not in nums:
                return i
        
        
            
