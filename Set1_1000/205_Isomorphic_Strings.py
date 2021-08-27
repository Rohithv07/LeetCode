class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dict = {}
        
        for x, y in enumerate(s):
            if y not in dict:
                if t[x] in dict.values(): 
                    return False
                dict[y] = t[x]
            else:
                if dict[y] != t[x]:
                    return False
        return True
                
