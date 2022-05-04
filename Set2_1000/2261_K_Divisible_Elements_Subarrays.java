class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int length = nums.length;
        Set<Long> hashTrack = new HashSet<>();
        for (int i = 0; i < length; i++) {
            // for hash collision taking a prime closer to 200 will be enough for the given constraints
            int distinctSubarrayCount = 0;
            long hashValue = 1;
            for (int j = i; j < length; j++) {
                hashValue = (hashValue * 199L) + nums[j];
                if (nums[j] % p == 0) {
                    distinctSubarrayCount++;
                }
                if (distinctSubarrayCount <= k) {
                    hashTrack.add(hashValue);
                }
            }
        }
        return hashTrack.size();
    }
}