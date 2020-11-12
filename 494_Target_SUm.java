// we can consider this as 0/1 knapsack problem where S is the bag capacity
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, 1);
        for (int number: nums) {
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int sum : map1.keySet()) {
                int positive = sum + number;
                map2.put(positive, map2.getOrDefault(positive, 0) + map1.get(sum));
                int negative = sum - number;
                map2.put(negative, map2.getOrDefault(negative, 0) + map1.get(sum));
            }
            map1 = map2;
        }
        return map1.getOrDefault(S, 0);
        
        
        // using dp array
        // lets find the total sum of the array first
        int sum = 0;
        for (int number : nums)
            sum += number;
        if (S < -sum || S > sum)
            return 0;
        int [][] dp = new int [nums.length+1][2*sum+1];
        dp[0][0+sum] = 1;
        for (int i=1; i<=nums.length; i++) {
            for (int j=0; j<2*sum+1; j++) {
                if (j+nums[i-1] < 2*sum+1)
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                if (j-nums[i-1] >= 0)
                    dp[i][j] += dp[i-1][j-nums[i-1]];
            }
        }
        return dp[nums.length][sum+S];
    }
}
