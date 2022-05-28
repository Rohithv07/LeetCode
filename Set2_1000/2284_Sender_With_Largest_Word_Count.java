class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        List<String> store = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            String s = senders[i];
            int count = 1;
            String current = messages[i];
            int length = current.length();
            int j = 0;
            while (j < length) {
                if (current.charAt(j) == ' ') {
                    count++;
                }
                j++;
            }
            if (map.containsKey(s)) {
               map.put(s, map.get(s) + count);
            }
            else {
                map.put(s, count);
            }
        }
        int max = Integer.MIN_VALUE;
        for (String s : map.keySet()) {
            max = Math.max(max, map.get(s));
        }
        for (String s : map.keySet()) {
            if (max == map.get(s)) {
                store.add(s);
            }
        }
        Collections.sort(store);
        return store.get(store.size() - 1);
    }
}