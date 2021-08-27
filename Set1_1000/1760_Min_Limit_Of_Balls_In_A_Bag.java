class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = (int)1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int n : nums) {
                count = count + (n - 1) / mid;
            }
            if (count > maxOperations) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}

// https://www.youtube.com/watch?v=5ET1d6PfbNU
