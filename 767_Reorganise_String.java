class Solution {
    public String reorganizeString(String s) {
        // get the count of each count
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        // use priority queue as maxHeap and use lambdas based on the count
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        // make the most frequent letter, then the next frequent letter and so on
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            char current = maxHeap.remove(); // maximum frequent
            char next = maxHeap.remove(); // next max
            sb.append(current);
            sb.append(next); // alternatively adding
            map.put(current, map.get(current) - 1);
            map.put(next, map.get(next) - 1);
            // if still the count > 0, add the charcaters back to heap
            if (map.get(current) > 0)
                maxHeap.add(current);
            if (map.get(next) > 0)
                maxHeap.add(next);
        }
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (map.get(last) > 1)
                return "";
            sb.append(last);
        }
        return sb.toString();
    }
}
