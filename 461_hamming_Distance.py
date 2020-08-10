class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        xor = x ^ y
        binary = bin(xor)
        b = binary[2:]
        hammingDistance = 0
        for item in b:
            if item == '1':
                hammingDistance += 1
        return hammingDistance
