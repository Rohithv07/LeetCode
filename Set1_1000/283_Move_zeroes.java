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


class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right++;
                left++;
            }
            else {
                right++;
            }
        }
    }
}

// in - place and minimum number of operations                 
