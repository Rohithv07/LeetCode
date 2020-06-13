class Solution:
    def addBinary(self, a: str, b: str) -> str:
        integer_sum = int(a, 2) + int(b, 2)
        return str("{0:b}".format(integer_sum))
