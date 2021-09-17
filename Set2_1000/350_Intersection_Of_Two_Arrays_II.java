class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int []{};
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        int [] intersection = new int [result.size()];
        for (i=0; i<result.size(); i++) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }
}

// we can make use of hashmap directily and check for the common elements that are in arr2 to arr1