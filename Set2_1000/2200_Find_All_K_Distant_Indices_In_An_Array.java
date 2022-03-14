class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        // finding all indexes for key
        // them traversing and finding |i - j| <= k and nums[j] = key
        Set<Integer> noDuplicateResult = new LinkedHashSet<>(); // to maintain the order and no duplicates
        List<Integer> keyIndex = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == key) {
                keyIndex.add(i);
            }
        }
        for (int index : keyIndex) {
            for (int i = 0; i < length; i++) {
                if (Math.abs(i - index) <= k) {
                    noDuplicateResult.add(i);
                }
            }
        }
        for (int number : noDuplicateResult) {
            result.add(number);
        }
        return result;
    }
}