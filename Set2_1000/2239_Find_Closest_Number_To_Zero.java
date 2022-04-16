class Solution {
    public int findClosestNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int distance = Integer.MAX_VALUE;
        int result = 0;
        for (int num : nums) {
            int currentDistance = Math.abs(num - 0);
            if (currentDistance < distance) {
                result = num;
                distance = currentDistance;
            }
            else if (currentDistance == distance) {
                if (num > result) {
                    result = num;
                }
            }
        }
        return result;
    }
}