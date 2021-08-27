class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        dict = {'(':')', '{':'}', '[':']'}
        
        for item in s:
            if item in dict:
                stack.append(item)
            elif stack:
                if dict[stack.pop()] != item:
                    return False
            else:
                return False
            
        return len(stack) == 0
