class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (condition(nums, threshold, middle))
                right = middle;
            else 
                left = middle + 1;
        }
        return left;
    } 
    public boolean condition(int [] nums, int threshold, int middle) {
        int total = 0;
        for (int num: nums) {
            total += (num-1) / middle + 1;
        }
        return total <= threshold;
    }
}
