// he TreeMap in Java is used to implement Map interface and NavigableMap along with the AbstractMap Class. The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used.

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        // count the numbers occurance
        for (int number: nums)
            map.put(number, map.getOrDefault(number, 0) + 1);
        // now consider the keys
        for (int keys: map.keySet()) {
            if (map.get(keys) > 0) {
                for (int i=k-1; i>=0; i--) {
                    if (map.getOrDefault(keys+i, 0) < map.get(keys))
                        return false;
                    //  else we update the map
                    map.put(keys+i, map.get(keys+i) - map.get(keys));
                }
            }
        }
        return true;
    }
}

// Time O(MlogM + MK), where M is the number of different cards here actually sorting takes place as we use a treemap
