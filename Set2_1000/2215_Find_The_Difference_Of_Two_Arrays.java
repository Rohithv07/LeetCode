class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        List<Integer> intermediate = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                intermediate.add(num);
            }
        }
        result.add(intermediate);
        intermediate = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                intermediate.add(num);
            }
        }
        result.add(intermediate);
        return result;
    }
}