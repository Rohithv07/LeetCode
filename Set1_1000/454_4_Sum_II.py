class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        dictionary = collections.defaultdict(int)
        totalCount = 0
        for x in A:
            for y in B:
                dictionary[x+y] += 1
        
        for x in C:
            for y in D:
                totalCount += dictionary[-(x+y)]
        return totalCount
