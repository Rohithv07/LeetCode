from collections import deque
class Solution:
    def removeDuplicates(self, S: str) -> str:
        if len(S) == 0:
            return S
        stack = deque()
        for element in S:
            if not stack or stack[-1] != element:
                stack.append(element)
            elif stack and stack[-1] == element:
                stack.pop()
        return ''.join(stack)
