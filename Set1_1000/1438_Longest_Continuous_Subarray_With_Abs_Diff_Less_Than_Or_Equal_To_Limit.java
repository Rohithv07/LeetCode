// can make use of treemap to get the maximum and minimum
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        int i = 0;
        for (i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j += 1;
            }
        }
        return i - j;
    }
}



