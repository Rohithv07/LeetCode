class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return preProcessProblem(nums1, nums2) + preProcessProblem(nums2, nums1);
    }
    public int preProcessProblem(int [] nums1, int [] nums2) {
        int result = 0;
        int n1 = nums1.length; 
        int n2 = nums2.length;
        Map<Long, Integer> map = new HashMap<>();
        for (int i=0; i<n1; i++) {
            map.put((long)nums1[i]*nums1[i], map.getOrDefault((long)nums1[i]*nums1[i], 0) + 1);
        }
        for (int j=0; j<n2; j++) {
            for (int k=j+1; k<n2; k++) {
                result += (long)map.getOrDefault((long)nums2[j]*nums2[k], 0);
            }
        }
        return result;
    }
}
