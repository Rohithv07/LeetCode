class Solution {
    public int maxProductDifference(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int length = nums.length;
        Arrays.sort(nums);
        long biggest = (nums[length - 1] * nums[length - 2]);
        long smallest = (nums[0] * nums[1]);
        return (int)(biggest - smallest);
    }
}

// Optimization - O(n) can be obtained by finding the biggest and second biggest element, smallestr and second smallest element
