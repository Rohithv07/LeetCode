class Solution:
    def isPalindrome(self, s: str) -> bool:
        if len(s) == 0:
            return True
        s = s.lower()
        s = [char for char in s if char.isalnum()]
        return s == s[::-1]
        
