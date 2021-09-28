class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        
        // using extra space
        
        int length = nums.length;
        int [] result = new int [length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int number : nums) {
            if (number % 2 == 0) {
                result[evenIndex] = number;
                evenIndex += 2;
            }
            else {
                result[oddIndex] = number;
                oddIndex += 2;
            }
        }
        return result;
        
        // in-place
        int length = nums.length;
        int evenIndex = 0;
        int oddIndex = 1;
        while (evenIndex < length && oddIndex < length) {
            while (evenIndex < length && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            while (oddIndex < length && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            if (evenIndex < length && oddIndex < length)
                swap(nums, evenIndex, oddIndex);
        }
        return nums;
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// swap using xor

private void swap(int [] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }