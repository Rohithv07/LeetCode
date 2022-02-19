class Solution {
    public int countPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pairCount = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    pairCount += 1;
                }
            }
        }
        return pairCount;
    }
}