class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left_min = 0
        right_max = len(numbers) - 1
        while left_min < right_max:
            if numbers[left_min] + numbers[right_max] < target:
                left_min += 1
            elif numbers[left_min] + numbers[right_max] > target:
                right_max -= 1
            else:
                return [left_min+1, right_max+1]
        
