class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        answer = []
        def backtrackSolution(string = '', left = 0, right = 0):
            if len(string) == 2 * n:
                answer.append(string)
                return 
            if left < n:
                backtrackSolution(string + '(', left + 1, right)
            if right < left:
                backtrackSolution(string + ')', left, right + 1)
                
        backtrackSolution()
        return answer
