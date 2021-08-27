class Solution:
    def titleToNumber(self, s: str) -> int:
        result = 0
        for elements in s:
            result = result * 26 + ord(elements) - ord('A') + 1
        return result
