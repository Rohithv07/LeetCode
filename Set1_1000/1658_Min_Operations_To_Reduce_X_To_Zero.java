class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        int length = nums.length;
        int sum = 0;
        for (int number:nums)
            target += number;
        if (target == 0)
            return length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = Integer.MIN_VALUE;
        for (int i=0; i<length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                result = Math.max(result, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return result == Integer.MIN_VALUE ? -1 : length - result;
    }
}




class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int number: nums)
            totalSum += number;
        if (totalSum < x)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int [] prefixSum = new int [nums.length];
        prefixSum[0] = nums[0];
        map.put(prefixSum[0], 0);
        for (int i=1; i<nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            map.put(prefixSum[i], i);
        }
        int longest = 0;
        totalSum -= x;
        int val = 0;
        for (int i=0; i<nums.length; i++) {
            val += nums[i];
            if (map.containsKey(val - totalSum)) {
                if (val - totalSum == 0)
                    longest = Math.max(longest, i-map.get(val-totalSum) + 1);
                else
                    longest = Math.max(longest, i-map.get(val-totalSum));
            }
        }
        return longest == 0 ? (totalSum == 0? n :- 1): n - longest;
    }
}
