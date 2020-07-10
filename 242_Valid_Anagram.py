class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
#        if len(s) != len(t):
#            return False
#        
#        dict1 = {}
#        dict2 = {}
        
#        for elements in s:
#            if elements in dict1.keys():
#                dict1[elements] += 1
#            else:
#                dict1[elements] = 1
        
#        for elements in t:
#            if elements in dict2.keys():
#                dict2[elements] += 1
#            else:
#                dict2[elements] = 1
        
#        return True if dict1 == dict2 else False
        return collections.Counter(s) == collections.Counter(t)
