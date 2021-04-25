class Solution {
    public int maxFrequency(int[] nums, long k) {
        int length = nums.length;
        if (length == 1)
            return 1;
        Arrays.sort(nums);
        int i=0;
        int j;
        for (j=0; j<length; j++) {
            k += nums[j];
            if (k < (long) nums[j] * (j - i + 1)) {
                k -= nums[i];
                i += 1;
            }
        }
        return j - i;
    }
}
