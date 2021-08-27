class Solution:
    def climbStairs(self, n: int) -> int:
        # SOlution 1
        def dynamic_way(n):
            if n not in memo:
                memo[n] = dynamic_way(n-1) + dynamic_way(n-2)
            return memo[n]
        
        memo = {1:1, 2:2}
        return dynamic_way(n)
    
        # Solution 2
        a, b = 1, 1
        for i in range(n):
            a, b = b, a + b
        return a
