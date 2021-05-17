class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 0 || words == null)
            return 0;
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            map.put(word, 1);
            for (int i=0; i<word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String compare = sb.deleteCharAt(i).toString();
                if (map.containsKey(compare) && map.get(compare) + 1 > map.get(word)) {
                    map.put(word, map.get(compare) + 1);
                }
            }
            result = Math.max(result, map.get(word));
        }
        return result;
    }
}
