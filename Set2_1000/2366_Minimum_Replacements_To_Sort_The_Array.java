class Solution {
    public long minimumReplacement(int[] nums) {
        long minReplacement = 0;
        int length = nums.length;
        int previous = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            int current = nums[i];
            int times = current / previous;
            if (current % previous != 0) {
                times++;
                previous = current / times;
                
            }
            minReplacement += times - 1;
        }
        return minReplacement;
    }
}