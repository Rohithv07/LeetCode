class Solution:
    def atMostNGivenDigitSet(self, D: List[str], N: int) -> int:
        N = str(N)
        length = len(N)
        res = sum(len(D) ** i for i in range(1, length))
        i = 0
        while i < length:
            res += sum(c < N[i] for c in D) * (len(D) ** (length - i - 1))
            if N[i] not in D:
                break
            i += 1
        return res + (i == length)
