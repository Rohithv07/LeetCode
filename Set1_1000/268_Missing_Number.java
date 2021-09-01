// using xor

class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 1 && nums[0] == 0)
            return 1;
        if (nums.length == 1 && nums[0] != 0)
            return nums[0] - 1;
        int xor = 0;
        int result = 0;
        int length = nums.length;
        int rightMost1Group = 0;
        int rightMost0Group = 0;
        for (int i=0; i<length; i++) {
            xor ^= nums[i];
        }
        for (int i=1; i<=length; i++) {
            xor ^= i;
        }
        int rightMost = xor & ~(xor - 1);
        for (int i=0; i<length; i++) {
            if ((nums[i] & rightMost) != 0) {
                rightMost1Group ^= nums[i];
            }
            else {
                rightMost0Group ^= nums[i];
            }
        }
        for (int i=1; i<=length; i++) {
            if ((i & rightMost) != 0) {
                rightMost1Group ^= i;
            }
            else {
                rightMost0Group ^= i;
            }
        }
        // one will be repeating if repeated and other will be missing
        for (int i=0; i<length; i++) {
            if (nums[i] == rightMost1Group) {
                result = rightMost0Group;
                break;
            }
            else if (nums[i] == rightMost0Group) {
                result = rightMost1Group;
                break;
            }
        }
        return result;
    }
}