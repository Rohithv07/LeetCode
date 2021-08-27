class Solution:
    def hammingWeight(self, n: int) -> int:
        temp = bin(n)
        return temp.count('1')
