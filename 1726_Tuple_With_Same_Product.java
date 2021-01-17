class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map =new HashMap<>();
        for (int i=0; i<n - 1; i++) {
            for (int j=i+1; j<n; j++) {
                count += 8 * map.getOrDefault(nums[i] * nums[j], 0);
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        return count;
    }
}
