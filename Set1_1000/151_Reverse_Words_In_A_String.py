class Solution:
    def reverseWords(self, s: str) -> str:
        
        result_str = ' '.join(s.split()[::-1])
        return result_str
