class Solution {
    public int partitionDisjoint(int[] nums) {
       //  Using extra space
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 2)
            return 1;
        int count = 0;
        int length = nums.length;
        int [] leftArray = new int [length]; // stores max from left to right
        int [] rightArray = new int [length]; // stores min from right to left
        int value = nums[0];
        for (int i=0; i<length; i++) {
            value = Math.max(value, nums[i]);
            leftArray[i] = value;
        }
        value = nums[length - 1];
        for (int i=length - 1 ; i >= 0; i--) {
            value = Math.min(value, nums[i]);
            rightArray[i] = value;
        }
        for (int i=1; i<length; i++) {
            int left = leftArray[i - 1];
            int right = rightArray[i];
            if (left <= right)
                return i;
        }
        return -1;
        
        // constant space
        if (nums == null || nums.length == 0)
            return 0;
        int currentMax = nums[0];
        int allTimeMax = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < currentMax) {
                currentMax = allTimeMax;
                count = i + 1;
            }
            else {
                allTimeMax = Math.max(allTimeMax, nums[i]);
            }
        }
        return count;
    }
}