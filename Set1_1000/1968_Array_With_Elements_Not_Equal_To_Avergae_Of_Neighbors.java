class Solution {
    public int[] rearrangeArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int []{};
        if (nums.length <= 2)
            return nums;
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
        return nums;
    }
}