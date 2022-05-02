class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        int evenIndex = 0;
        int i = 0;
        while (i < length) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, evenIndex);
                evenIndex++;
            }
            i++;
        }
        return nums;
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        int evenCount = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                evenCount++;
        }
        int evenStarting = 0;
        int oddStarting = evenCount;
        int [] result = new int [length];
        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenStarting++] = num;
            }
            else {
                result[oddStarting++] = num;
            }
        }
        return result;
    }
}