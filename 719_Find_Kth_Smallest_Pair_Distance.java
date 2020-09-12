class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n-1] - nums[0];
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isSmaller(middle, nums, k, n))
                right = middle;
            else 
                left = middle + 1;
        }
        return left;
    }
    public boolean isSmaller(int middle, int [] nums, int k, int n) {
        int count = 0;
        int i=0;
        int j = 0;
        while (i < n  || j < n) {
            while (j < n && nums[j] - nums[i] <= middle) {
                j += 1;
            }
            count += j-i-1;
            i += 1;
        }
        return count >= k;
    }
}
