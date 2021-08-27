class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res, i, j = '', 0, 0
        try:
            while True:
                if i == len(strs) - 1:
                    res = res + strs[0][j]
                    i = 0
                    j = j + 1
                if strs[i][j] == strs[i+1][j]:
                    i = i + 1
                else:
                    return res
        except:
            return res
            