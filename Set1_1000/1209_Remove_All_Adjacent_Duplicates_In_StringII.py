class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        size = len(s)
        count = 1
        for i in range(1, size):
            if s[i-1] == s[i]:
                count += 1
            elif s[i-1] != s[i]:
                count = 1
            if count == k:
                s = s.replace(s[i-k+1:i+1], '')
                return self.removeDuplicates(s, k)
        return s
