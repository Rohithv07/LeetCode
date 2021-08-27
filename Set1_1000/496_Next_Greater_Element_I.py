class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = collections.deque()
        checkingDictionary = {}
        answer = []
        for element in nums2:
            while stack and element > stack[-1]:
                checkingDictionary[stack.pop()] = element
            stack.append(element)
            
        for element in nums1:
            if element in checkingDictionary:
                answer.append(checkingDictionary[element])
            else:
                answer.append(-1)
        return answer
        
