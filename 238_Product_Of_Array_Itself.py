class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product = 1
        product_non_zero = 1
        counter_zero = 0
        for elements in nums:
            product = product * elements
            if elements == 0:
                counter_zero += 1
            else:
                product_non_zero *= elements
                
        res =[0] * len(nums)
        if product != 0:
            for i in range(len(nums)):
                res[i] = product // nums[i]
        elif counter_zero == 1:
            for i in range(len(nums)):
                if nums[i] == 0:
                    res[i] = product_non_zero
                    
        return res
