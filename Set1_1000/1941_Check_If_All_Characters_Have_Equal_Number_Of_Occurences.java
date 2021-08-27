class Solution {
    public boolean areOccurrencesEqual(String s) {
        if (s.length() == 1)
            return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int freq = map.get(s.charAt(0));
        for (char key : map.keySet()) {
            if (map.get(key) != freq)
                return false;
        }
        return true;
    }
}