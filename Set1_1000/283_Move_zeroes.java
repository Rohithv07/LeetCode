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




// another method using count of zero

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int count = 0;
        for (int i=0; i<length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            else {
                if (count > 0) {
                    int temp = nums[i];
                    nums[i] = 0;
                    nums[i - count] = temp;
                }
            }
        }
    }
}