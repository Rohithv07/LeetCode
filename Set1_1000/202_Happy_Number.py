class Solution:
    def square_number(self, n):
        total = 0
        while(n > 0):
            total = total + (n % 10) ** 2
            n = n // 10
        return total
    
    def isHappy(self, n: int) -> bool:
        slow = n
        result = self.square_number(n)
        while(result != 1 and slow != result):
            slow = self.square_number(slow)
            result = self.square_number(result)
            result = self.square_number(result)
        
        return result == 1
