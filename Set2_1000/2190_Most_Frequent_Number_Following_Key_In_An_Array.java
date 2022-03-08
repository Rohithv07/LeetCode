class Solution {
    public int mostFrequent(int[] nums, int key) {
        int [] frequency = new int [1001]; // from constraint
        int length = nums.length;
        int resultElement = 0;
        int maxOccuring = 0;
        for (int i = 0; i + 1 < length; i++) {
            if (nums[i] == key) {
                frequency[nums[i + 1]]++;
            }
        }
        for (int i = 1; i <= 1000; i++) {
            if (frequency[i] > maxOccuring) {
                resultElement = i;
                maxOccuring = frequency[i];
            }
        }
        return resultElement;
    }
}