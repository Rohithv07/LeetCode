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

// space optimised
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (Math.abs(i - j) <= k && nums[j] == key) {
                    result.add(i);
                    break;// this will take care of duplicate and we can remove extra space
                }
            }
        }
        return result;
    }
}