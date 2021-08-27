class Solution:
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        if N == 1:
            return [i for i in range(10)]
        answer = []
        def dfsHelperFunction(N, num):
            if N == 0:
                return answer.append(num)
            tail = num % 10
            nextDigits = set([tail + K, tail - K])
            for digits in nextDigits:
                if 0 <= digits < 10:
                    nextValidOne = num * 10 + digits
                    dfsHelperFunction(N-1, nextValidOne)
            
        for i in range(1, 10):
            dfsHelperFunction(N-1, i)
            
        return answer
