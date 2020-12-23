class Solution:
    def nextGreaterElement(self, n):
        digits = list(str(n))
        length = len(digits)
        
        i, j = length-2, length-1
        while i >= 0 and digits[i+1] <= digits[i]:
            i -= 1
        
        if i == -1: return -1

        while digits[j] <= digits[i]:
            j -= 1
        
        digits[i], digits[j] = digits[j], digits[i]

        res = int(''.join(digits[:i+1] + digits[i+1:][::-1]))
        if res >= 2**31 or res == n:
            return -1
        return res
