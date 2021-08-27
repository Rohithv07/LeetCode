class Solution:
    def validPalindrome(self, s: str) -> bool:
        def isPalindrome(string, left, right):
            while (left < right):
                if string[left] != string[right]:
                    return False
                left += 1
                right -= 1
            return True
        
        left = 0
        right = len(s) - 1
        while (left < right):
            if (s[left] == s[right]):
                left += 1
                right -= 1
            else:
                if isPalindrome(s, left+1, right):
                    return True
                if isPalindrome(s, left, right-1):
                    return True
                return False
        return True
