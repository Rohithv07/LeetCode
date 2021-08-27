
class Solution {
    public int findNumbers(int[] nums) {
        if (nums.length == 0)
            return 0;
        int [] storeDigit = new int [nums.length];
        for (int i=0; i<nums.length; i++)
            nums[i] = numberOfDigit(nums[i]);
        int finalCount = 0;
        for (int value: nums) {
            if (value % 2 == 0)
                finalCount ++;
        }
        return finalCount;
    }
    public int numberOfDigit(int number) {
        int count = 0;
        while (number > 0) {
            count += 1;
            number = number / 10;
        }
        return count;
    }
}

class Solution {
    public int findNumbers(int [] nums) {
        if (nums.length == 0)
            return 0;
        int finalCount = 0;
        for (int number: nums) {
            if ((number > 9 && number < 100) || (number > 999 && number < 10000) || number == 100000)
                finalCount += 1;
        }
        return finalCount;
    }
}
