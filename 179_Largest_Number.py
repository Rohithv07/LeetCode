class Larger(str):
    def __lt__(x, y):
        return x+y > y+x

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        largestNum = ''.join(sorted(map(str, nums), key=Larger))
        return '0' if largestNum[0] == '0' else largestNum
