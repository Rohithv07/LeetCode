class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int counter = map.size(); //  as t may still have duplicates
        int left = 0;
        int right = 0;
        int head = 0;
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            char current = s.charAt(right);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0)
                    counter -= 1;
            }
            right += 1;
            while (counter == 0) {
                char inBetween = s.charAt(left);
                if (map.containsKey(inBetween)) {
                    map.put(inBetween, map.get(inBetween) + 1);
                    if (map.get(inBetween) > 0)
                        counter += 1;
                }
                if (right - left < length) {
                    length = right - left;
                    head = left;
                }
                left += 1; 
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(head, head + length);
    }
}
