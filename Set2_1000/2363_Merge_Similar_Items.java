class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> valueWeight = new HashMap<>();
        for (int [] item : items1) {
            int value = item[0];
            int weight = item[1];
            valueWeight.put(value, valueWeight.getOrDefault(value, 0) + weight);
        }
        for (int [] item : items2) {
            int value = item[0];
            int weight = item[1];
            valueWeight.put(value, valueWeight.getOrDefault(value, 0) + weight);
        }
        for (int key : valueWeight.keySet()) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(key);
            currentList.add(valueWeight.get(key));
            result.add(new ArrayList<>(currentList));
        }
        Collections.sort(result, (a1, a2) -> Integer.compare(a1.get(0), a2.get(0)));
        return result;
    }
}