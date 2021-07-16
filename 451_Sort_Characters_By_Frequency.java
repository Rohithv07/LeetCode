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

// without using hashmap but a count array

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        int length = s.length();
        Pair [] count = new Pair[256];
        for (char ch : s.toCharArray()) {
            if (count[ch] == null)
                count[ch] = new Pair(ch, 1);
            else
                count[ch].freq += 1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.freq, p1.freq));
        for (Pair p : count) {
            if (p != null) {
                pq.add(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair currentPair = pq.poll();
            int currentFreq = currentPair.freq;
            for (int i=0; i<currentFreq; i++) {
                sb.append(currentPair.ch);
            }
        }
        // for (Pair p : count) {
        //     if (p != null)
        //     System.out.println(p.ch + " " + p.freq);
        // }
        return sb.toString();
    }
}

class Pair {
    char ch;
    int freq;
    
    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}