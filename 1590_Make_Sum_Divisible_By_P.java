Find smallest subarray that the sum is X

class Solution {
    public int minSubarray(int[] nums, int p) {
        int length = nums.length;
        int sum = 0;
        for (int i=0; i<length; i++)
            sum = (sum + nums[i]) % p;
        if (sum == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = length;
        int currentSum = 0;
        for (int i=0; i<length; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int difference = (currentSum - sum + p) % p;
            if (map.containsKey(difference)) {
                int finalLength = i - map.get(difference);
                result = Math.min(finalLength, result);
            }
            map.put(currentSum, i);
        }
        if (result == length)
            return -1;
        else
            return result;
    }
}
