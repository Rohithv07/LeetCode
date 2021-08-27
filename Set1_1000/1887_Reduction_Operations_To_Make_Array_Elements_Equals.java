class Solution {
    public int reductionOperations(int[] nums) {
        if (nums.length == 1)
            return 0;
        int length = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for (int i=length - 1; i>0; i--) {
            if (nums[i] != nums[i - 1]) {
                result += length - i;
            }
        }
        return result;
    }
}
