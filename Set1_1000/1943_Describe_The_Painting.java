class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        // add color value at the start and subtract color value at the end
        // use a treemap to have it sorted - nlogn
        Map<Integer, Long> map = new TreeMap<>();
        for (int [] seg : segments) {
            map.put(seg[0], map.getOrDefault(seg[0], 0L) + seg[2]); // adding color at start
            map.put(seg[1], map.getOrDefault(seg[1], 0L) - seg[2]); // subtracting color at end
        }
        long sum = 0;
        int previous = 0;
        List<List<Long>> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (sum != 0) {
                List<Long> store = new ArrayList<>();
                store.add((long) previous);
                store.add((long) key);
                store.add(sum);
                result.add(store);
            }
            sum += map.get(key);
            previous = key;
        }
        return result;
    }
}