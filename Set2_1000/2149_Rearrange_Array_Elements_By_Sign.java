// approach 1

class Solution {
    public int[] rearrangeArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int [] plus = new int [length / 2];
        int [] minus = new int [length / 2];
        int indexPlus = 0;
        int indexMinus = 0;
        for (int number : nums) {
            if (number > 0) {
                plus[indexPlus++] = number;
            }
            else {
                minus[indexMinus++] = number;
            }
        }
        indexPlus = 0;
        indexMinus = 0;
        for (int i=0; i<length; i++) {
            if (i % 2 == 0) {
                nums[i] = plus[indexPlus++];
            }
            else {
                nums[i] = minus[indexMinus++];
            }
        }
        return nums;
    }
}

// two pointer

class Solution {
    public int[] rearrangeArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int [] result = new int [length];
        int positive = 0;
        int negative = 0;
        for (int i=0; i<length; i++) {
            while (positive < length && nums[positive] > 0) {
                positive++;
            }
            while (negative < length && nums[negative] < 0) {
                negative++;
            }
            result[i] = (i % 2 == 1) ? nums[positive++] : nums[negative++]; 
        }
        return result;
    }
}