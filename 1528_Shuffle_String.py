class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        result = list(s)
        for i in range(len(result)):
            result[indices[i]] = s[i]
        return ''.join(result)
