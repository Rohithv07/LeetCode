class Solution:
    def balancedStringSplit(self, s: str) -> int:
        cum_sum = 0
        counter = 0
        
        for elements in s:
            if elements == "R":
                cum_sum += 1
            else:
                cum_sum -= 1
            
            if cum_sum == 0:
                counter += 1
                
        return counter
