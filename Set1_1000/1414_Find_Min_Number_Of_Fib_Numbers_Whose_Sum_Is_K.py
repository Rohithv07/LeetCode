class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        res = 0
        a = 1
        b = 1
        while b <= k:
            a, b = b, a+b
        while a > 0:
            if a <= k:
                k -= a
                res += 1
            a, b = b - a, a
        return res
