class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = nums.length+1;
        int left = 0;
        int sum = 0;
        for (int right=0; right<nums.length; right++) {
            sum += nums[right];
            while(sum >= s && left <= right) {
                minLength = Math.min(minLength, right-left+1);
                sum -= nums[left];
                left += 1;
            }
        }
        if (minLength == nums.length+1)
            return 0;
        else 
            return minLength;
    }
}
