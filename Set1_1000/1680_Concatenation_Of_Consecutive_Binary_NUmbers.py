class Solution:
    def concatenatedBinary(self, n: int) -> int:
        result = 0
        i = 1
        while i <= n:
            result = ((result << (1 + int(log(i, 2)))) % 1000000007 + i) % 1000000007
            i = i + 1
        return result % 10000000007
    
    
    
"""
https://www.youtube.com/watch?v=ttlNQ6YrdGs this is the reference video with good explanation


p = previously calculted value
x = current number
D = number of digits = log2(x) + 1
Then new decimal value = (p * 2 ^ D) + x
"""
