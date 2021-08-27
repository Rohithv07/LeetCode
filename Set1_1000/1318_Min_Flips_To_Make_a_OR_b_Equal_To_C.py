class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        numberOfFlips = 0
        while a or b or c:
            if (a&1) | (b&1) != (c&1):
                if c&1:
                    numberOfFlips += 1
                else:
                    numberOfFlips += (a&1) + (b&1)
            a, b, c = a >> 1, b >> 1, c >> 1
        return numberOfFlips;
