class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        int length = nums.length;
        Map<String, Integer> tracker = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String current = nums[i];
            if (target.startsWith(current)) {
                String suffix = target.substring(current.length());
                count += tracker.getOrDefault(suffix, 0);
            }
            if (target.endsWith(current)) {
                String prefix = target.substring(0, target.length() - current.length());
                count += tracker.getOrDefault(prefix, 0);
            }
            tracker.put(current, tracker.getOrDefault(current, 0) + 1);
        }
        return count;
    }
}