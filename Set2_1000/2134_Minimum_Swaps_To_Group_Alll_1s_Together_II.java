class Solution {
    public int minSwaps(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int totalNumberOfOnes = 0;
        for (int number : nums) {
            if (number == 1)
                totalNumberOfOnes += 1;
        }
        if (totalNumberOfOnes == length || totalNumberOfOnes == 0) {
            return 0;
        }
        // find how many 1's in the first totalNumberOfOnes window
        // this is the fixed window as we need to group them together
        int numberOfOnesInCurrent = 0;
        int maximumNumberOfOnesInWindow = 0;
        int i = 0;
        for (i=0; i<totalNumberOfOnes; i++) {
            if (nums[i] == 1) {
                maximumNumberOfOnesInWindow += 1;
            }
        }
        numberOfOnesInCurrent = maximumNumberOfOnesInWindow;
        for (; i<length + totalNumberOfOnes; i++) {
            //In this step we are moving window forward by one step
            //if nums[i%n] is 1 then add 1 to onesInCurrWindow
            //if nums[i - totalOnes] is 1 then subtrct 1 from onesInCurrWindow
            numberOfOnesInCurrent += (nums[i % length] - nums[i - totalNumberOfOnes]);
            maximumNumberOfOnesInWindow = Math.max(maximumNumberOfOnesInWindow, numberOfOnesInCurrent);
        }
        return totalNumberOfOnes - maximumNumberOfOnesInWindow;
    }
}