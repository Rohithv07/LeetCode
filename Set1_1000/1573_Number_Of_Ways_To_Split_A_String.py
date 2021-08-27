class Solution:
    def numWays(self, s: str) -> int:
        mod = 10 ** 9 + 7
        # 1. first find the count of 1
        countOf1 = s.count('1')
        
        # 2. Check whether the count % 3 == 0 as we need to split to 3 parts
        if countOf1 % 3 != 0:
            return 0
        # 3. Check whether there is only 0 in the string
        if countOf1 == 0:
            return (len(s)-1) * (len(s) - 2) // 2 % mod
        
        # 4. Keep a list to store the index of 1 and we multiply by the total number of 0's in 1st and 2nd part, 2nd part and 3rd part
        
        oneCount = []
        for index, value in enumerate(s):
            if value == '1':
                oneCount.append(index)
        return (oneCount[countOf1//3] - oneCount[countOf1//3 - 1]) * (oneCount[2*countOf1//3] - oneCount[2*countOf1//3 - 1]) % mod 
            
