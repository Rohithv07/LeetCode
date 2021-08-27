class Solution {
    public int findPeakElement(int[] nums) {
        // linear scan with extra space
        
        int length = nums.length;
        if (length == 1 || nums[0] > nums[1])
            return 0;
        int [] everyNums = new int [length + 1];
        everyNums[length] = Integer.MIN_VALUE;
        for (int i=0; i<length; i++)
            everyNums[i] = nums[i];
        for (int i=1; i<length; i++) {
            if (everyNums[i - 1] < everyNums[i] && everyNums[i] > everyNums[i + 1])
                return i;
        }
        return 0;
        
        // binary search
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[middle + 1])
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
}
