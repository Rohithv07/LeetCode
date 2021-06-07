class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;
        int length = nums.length;
        int leftSum = 0;
        int rightSum = 0; // total sum
        for (int number : nums) {
            rightSum += number;
        }
        for (int i=0; i<length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
    
}
