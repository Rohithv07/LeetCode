class Solution {
    public void moveZeroes(int[] nums) {
        int next = 0;
        for (int number : nums) {
            if (number != 0)
                nums[next++] = number;
        }
        for (int i=next; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}
