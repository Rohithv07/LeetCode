class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        split = str.split()
        dict = {}
        if len(pattern) != len(split):
            return False
        
        for i in range(len(pattern)):
            if pattern[i] not in dict:
                if split[i] not in dict.values():
                    dict[pattern[i]] = split[i]
                else:   
                    return False
            
        new_str = ' '.join(dict[i] for i in pattern)
        return str == new_str
