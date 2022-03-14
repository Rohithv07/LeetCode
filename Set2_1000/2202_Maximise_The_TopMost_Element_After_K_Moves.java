class Solution {
    public int maximumTop(int[] nums, int k) {
        if (k == 0) {
            return nums.length > 0 ? nums[0] : -1;
        }
        if (k == 1) {
            return nums.length == 1 ? -1 : nums[1]; // a sure removal will happen if there are more than 1 element
        }
        // single element but have even or odd k
        if (nums.length == 1) {
            if (k % 2 == 0) {
                return nums[0];
            }
            return -1;
        }
        int length = nums.length;
        int maxSeenSoFar = -1;
        // find what is the max upto k - 1
        // keep in mind that our k can be greater than length
        for (int i = 0; i < Math.min(k - 1, length); i++) {
            if (maxSeenSoFar < nums[i]) {
                maxSeenSoFar = nums[i];
            }
        }

        // if our k is >= length, the max seen so far is the answer
        // else the max seen so far or the kth element in array will be the answer
        return k >= length ? maxSeenSoFar : Math.max(maxSeenSoFar, nums[k]);
    }
}