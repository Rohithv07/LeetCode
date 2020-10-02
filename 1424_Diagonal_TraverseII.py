"""
If we pass ‘list’ (without the quotes) to the defaultdict() Pytohn function, we can group a sequence of key-value pairs into a dictionary of lists. We can do this to more types as well. We’ll see another in the next section.

>>> a=[('a',1),('b',2),('c',3)]
>>> b=defaultdict(list)
>>> for i,j in a:
                b[i].append(j)              
>>> b
defaultdict(<class ‘list’>, {‘a’: [1], ‘b’: [2], ‘c’: [3]})
"""

class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        dictionary = defaultdict(list)
        for i in range(len(nums)):
            for j in range(len(nums[i])):
                dictionary[i+j].append(nums[i][j])
        return [v for k in dictionary.keys() for v in reversed(dictionary[k])]
