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
