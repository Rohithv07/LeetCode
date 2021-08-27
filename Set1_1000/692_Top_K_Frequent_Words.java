class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> result = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> map.get(w1) == map.get(w2) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for (String key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k)
                pq.remove();
        }
        while (!pq.isEmpty()) {
            result.add(pq.remove());
        }
        Collections.reverse(result);
        return result;
    }
}
