class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int [] a, int [] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int length = queries.length;
        int [] result = new int [length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int maxBeauty = 0;
        for (int [] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            map.put(item[0], maxBeauty);
        }
        int index = 0;
        for (int query : queries) {
            Integer key = map.floorKey(query);
            result[index++] = key == null ? 0 : map.get(key);
        }
        return result;
    }
}