from collections import deque
class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        def buildString(string):
            stack = deque()
            for element in string:
                if element != '#':
                    stack.append(element)
                elif stack:
                    stack.pop()
            return ''.join(stack)
        
        return buildString(S) == buildString(T)
