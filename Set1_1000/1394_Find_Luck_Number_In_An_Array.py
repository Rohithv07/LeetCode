"""
My Thought proces:
So here we need the frequencies of each and every element. So I used the built in functions collections.Counter which stores the value and the count as key-value pair in a dictionary.
So its given if there are multiple lucky integers, we need to find the largest, So I created a varibale largest to track the large element and initialise it with -1.
Now iterate through the dictionary and check whetehr
    key == val && largest < key, then update largest to key
Finally return largest
"""

class Solution:
    def findLucky(self, arr: List[int]) -> int:
        frequencies = collections.Counter(arr);
        largest = -1
        for key, val in frequencies.items():
            if key == val and largest < key:
                largest = key
        return largest
