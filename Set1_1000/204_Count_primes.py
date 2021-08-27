class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3:
            return 0
        dp = [0, 0] + [1] * (n - 2)
        for i in range(2, int(n ** 0.5) + 1):
            if dp[i]:
                dp[i ** 2:n:i] = [0] * len(dp[i ** 2:n:i])
        return sum(dp)
                
