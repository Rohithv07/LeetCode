class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        int [] prefix = new int [length + 1];
        prefix[0] = 0;
        for (int i = 0; i < length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        // we need to find the number of zeros to left + number of ones in right
        int maximumScore = -1;
        int zeroLeft = 0;
        int oneRight = 0;
        int currentScore = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            oneRight = prefix[length] - prefix[i]; //total number of 1s - number of ones till i
            zeroLeft = i - prefix[i]; // i is number of elements - number of ones till i
            currentScore = oneRight + zeroLeft;
            if (currentScore > maximumScore) {
                maximumScore = currentScore;
                result.clear();
            }
            if (currentScore == maximumScore) {
                result.add(i);
            }
        }
        return result;
    }
}