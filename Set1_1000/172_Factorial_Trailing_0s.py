class Solution:
    def trailingZeroes(self, n: int) -> int:
        result = 0
        while(n):
            n = n // 5
            result += n
        return result
