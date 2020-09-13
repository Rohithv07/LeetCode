class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        indeX = -1
        listS = list(s)
        for element in listS:
            try:
                indeX = t.index(element)
            except:
                return False
            t = t[indeX+1:]
        return True
