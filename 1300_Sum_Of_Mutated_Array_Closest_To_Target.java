class Solution {
    public int findBestValue(int[] arr, int target) {
        int maximumValue = Arrays.stream(arr).max().getAsInt();
        int difference = target;
        int previousValue = maximumValue;
        int left = 0;
        int right = maximumValue;
        // binary search O(logn)
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int currentSum = findSum(arr, middle);
            int currentDiff = Math.abs(target - currentSum);
            if (currentDiff < difference) {
                difference = currentDiff;
                previousValue = middle;
            }
            else if (currentDiff == difference) {
                previousValue = Math.min(previousValue, middle);
            }
            if (currentSum > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return previousValue;
    }
    public int findSum(int [] array, int value) {
        int sum = 0;
        for (int number: array) {
            sum += number > value ? value : number;
        }
        return sum;
    }
}
