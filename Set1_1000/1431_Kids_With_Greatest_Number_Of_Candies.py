"""
My thought process:

So we are given an array with number of candies in each kid and extraCandies which says about the extra candies available. So if we give extra candies to each of the student, we need have a True value if the number of candies exceeds the max(candies).

So ofcourse we require the maximum value from the candies array and we make our comparison with respect to this value.
Now in python we can easily do a list comprehension.
So here typically what happens means if the current candy + extra candies exceeds the maximum number of candies, then we have a True vale, else we have False value. Thats it this is what the problem is after.
Return this statement and we get our answer.
""" 


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        m = max(candies)
        return [True if extraCandies+i >= m else False for i in candies]
