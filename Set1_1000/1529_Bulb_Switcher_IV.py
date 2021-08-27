class Solution:
    def minFlips(self, target: str) -> int:
        if target.count('0') == 0:
            return 0
        initialState = '0'
        flipCount = 0
        for element in target:
            if initialState != element:
                flipCount += 1
                if initialState == '0':
                    initialState ='1'
                else:
                    initialState = '0'
                    
        return flipCount
        
