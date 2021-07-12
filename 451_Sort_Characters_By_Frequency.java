class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        Map<Character, Integer> occurance = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            occurance.put(ch, occurance.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> sortedOnFreq = new PriorityQueue<>((a, b) -> occurance.get(a) != occurance.get(b) ? Integer.compare(occurance.get(b), occurance.get(a)) : Integer.compare(a, b));
        for (char ch : occurance.keySet()) {
            sortedOnFreq.offer(ch);
        }
        while (!sortedOnFreq.isEmpty()) {
            char current = sortedOnFreq.poll();
            int freq = occurance.get(current);
            for (int i=0; i<freq; i++) {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}