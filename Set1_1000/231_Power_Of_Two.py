class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        while(n > 1):
            n = n / 2
        return True if n == 1.0 else False
