# we can make use of a hashmap
# lets store the double of the each array as a key inside the hashmap
# now traverse through the array and check whther there is a key which is double 
# if we found one, return true, else return false

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        if arr[0] == 0 and arr[1] == 0:
            return True
        dictionary = {}
        for number in arr:
            dictionary[2*number] = True
        for number in arr:
            
            if number in dictionary and number != 0:
                return True
        return False
        
