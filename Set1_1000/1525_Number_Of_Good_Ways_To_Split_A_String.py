class Solution:
    def numSplits(self, s: str) -> int:
        if len(s) == 0:
            return 0
        count = 0
        counterLeft = collections.Counter()
        counterRight = collections.Counter(s)
        for element in s:
            counterLeft[element] += 1
            counterRight[element] -= 1
            if counterRight[element] == 0:
                counterRight.pop(element)
            if len(counterLeft) == len(counterRight):
                count += 1
        return count
