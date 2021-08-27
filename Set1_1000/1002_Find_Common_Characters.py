class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        if len(A) < 2:
            return A
        
        count = Counter(A[0])
        for elements in A:
            count &= Counter(elements)
            
        return count.elements()
