class Solution:
    def isUgly(self, num: int) -> bool:
        if num < 1:
            return False
        while num%2 == 0 or num%5 == 0 or num%3 == 0:
            for i in [2, 3, 5]:
                if num % i == 0:
                    num = num / i
        
        return num == 1
