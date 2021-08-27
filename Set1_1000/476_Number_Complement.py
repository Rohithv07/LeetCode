class Solution:
    def findComplement(self, N: int) -> int:
        x = 1
        while N > x:
            x = x * 2 + 1
        return x - N
