class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        countS = collections.Counter(s)  
        countT = collections.Counter(t)
        for elements in t:
            if elements not in countS:
                return elements
            elif elements in countS and countS[elements] != countT[elements]:
                return elements
        return ''
