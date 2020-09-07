class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int [] result = new int [n];
        Arrays.fill(result, 1);
        TreeSet<Integer> emptyLake = new TreeSet<>(); // O(logn)
        Map<Integer, Integer> fullLake = new HashMap<>();
        for (int i=0; i<n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                result[i] = -1;
                if (fullLake.containsKey(lake)) {
                    Integer emptyDate = emptyLake.higher(fullLake.get(lake));
                    if (emptyDate == null)
                        return new int [0];
                    result[emptyDate] = lake;
                    emptyLake.remove(emptyDate);
                }
                    fullLake.put(lake, i);
            }
            else {
                emptyLake.add(i);
            }
        }
        return result;
    }
}
