//Count the elements with Counter
//If k > 0, for each element i, check if i + k exist.
//If k == 0, for each element i, check if count[i] > 1

class Solution {
    public int findPairs(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number: nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int x: map.keySet()) {
            if ((k>0 && map.containsKey(x+k)) || (k == 0 && map.get(x) > 1))
                pairs += 1;
        }
        return pairs;
    }
}
