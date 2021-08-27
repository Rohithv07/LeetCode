class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int number: nums1) {
            set1.add(number);
        }
        int i = 0;
        for (int number:nums2) {
            if (set1.contains(number))
                result.add(number);
        }
        int [] finalResult = new int [result.size()];
        for (int number: result) {
            finalResult[i++] = number;
        }
        return finalResult;
    }
}
