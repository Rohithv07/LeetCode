Python : Using DP ARRAY
class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        result = 0
        dp = [0] * len(arr)
        if (arr[0] % 2 != 0):
            dp[0] = 1
        result = dp[0]
        for i in range(1, len(arr)):
            if (arr[i] % 2 == 0):
                dp[i] = dp[i-1]
            else:
                dp[i] = i - dp[i-1] + 1
            result = (result + dp[i]) % (10 ** 9 + 7)
        return result


Python : Without DP Array
class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        count = arr[0] % 2
        currentCount = count
        for i in range(1, len(arr)):
            if (arr[i] % 2):
                currentCount = i - currentCount + 1
            count += currentCount
        return count % (10 ** 9 + 7)
