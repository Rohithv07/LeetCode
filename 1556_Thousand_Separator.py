class Solution:
    def thousandSeparator(self, n: int) -> str:
        resultString = str(n)
        resultString = resultString[::-1]
        result = '.'.join(resultString[i:i+3] for i in range(0, len(resultString), 3))
        
        return result[::-1]
                
