class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> trackCount = new HashMap<>();
        for (int num : nums) {
            int mod = num % space;
            trackCount.put(mod, trackCount.getOrDefault(mod, 0) + 1);
        }
        int maximumCountRecorded = Collections.max(trackCount.values());
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            int mod = num % space;
            if (trackCount.get(mod) == maximumCountRecorded) {
                result = Math.min(result, num);
            }
        }
        return result;
    }
}