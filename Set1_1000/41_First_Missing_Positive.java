class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        // here the idea if we have just positive numbers is just scan the array from left to right
        // say we have array 1 3 4 5
        // its index is      1 2 3 4
        // now we have 1 at 1st index, so we just multiply the number at 1st index by -1
        // next we have 3 at index 2, so we just multiply the number at 3rd index by -1
        // next we have 4, so we just multiply the number at 4th index by -1
        // next we have 5, but our array size is only 4, so we just ignore this number
        // now our array after this scan will be
        // -1 3 -4 -5
        //  1 2  3  4
        // so now we just again scan and check which index is having a positive number at the earliest
        // then that index will be the answer
        // else the last index + 1 will be our answer
        // now if we got a negative number in the array, or zeros then this will surely fail


        // now the efficient idea is to put the number 1 at 1st index, 2 at 2nd index, 3 at 3rd index etc.
        // when the number > length or <= 0, just ignore it
        // after doing this, just once more scan the array and check whether the numbers are ordered properly
        // if there is a misorder, then the index of misorder is the smallest positive number
        
        // ref : https://youtu.be/-lfHWWMmXXM
        
        int length = nums.length;
        for (int i=0; i<length; i++) {
            int correctPosition = nums[i] - 1;
            while (nums[i] >= 1 && nums[i] <= length && nums[i] != nums[correctPosition]) {
                swap(nums, i, correctPosition);
                correctPosition = nums[i] - 1;
            }
        }
        for (int i=0; i<length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}