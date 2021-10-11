class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        // we traverse from right to left and check which number is the one which is not in increasing way
        // now after finding this number, move to the right for finding any number just greater than this small number
        // swap these two number
        // now just reverse the numbers from the swapping + 1 position to the end
        int nonIncreasing = -1;
        int nonIncreasingIndex = -1;
        int length = nums.length;
        for (int i=length - 1; i>0; i--) {
            if (nums[i] > nums[i - 1]) {
                nonIncreasing = nums[i - 1];
                nonIncreasingIndex = i - 1;
                break;
            }
        }
        if (nonIncreasing == -1) {
            // already largest possible, so just reverse the whole array
            reverse(nums, 0, length - 1);
            return;
        }
        int justGreater = nonIncreasing;
        int justGreaterIndex = nonIncreasingIndex + 1;
        int larger = nums[nonIncreasingIndex + 1];
        for (int i=nonIncreasingIndex + 1; i<length; i++) {
            if (nums[i] > nonIncreasing && nums[i] <= larger) {
                justGreater = nums[i];
                justGreaterIndex = i;
            }
        }
        swap(nums, nonIncreasingIndex, justGreaterIndex);
        reverse(nums, nonIncreasingIndex + 1, length - 1);
        
    }
    
    public void reverse(int [] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}