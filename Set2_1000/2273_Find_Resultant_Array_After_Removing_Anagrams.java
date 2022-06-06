class Solution {
    public List<String> removeAnagrams(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        char [] current = words[0].toCharArray();
        Arrays.sort(current);
        String top = new String(current);
        for (int i = 1; i < words.length; i++) {
            current = words[i].toCharArray();
            Arrays.sort(current);
            String currentTop = new String(current);
            if (top.equals(currentTop)) {
                continue;
            }
            result.add(words[i]);
            top = currentTop;
        }
        return result;
    }
}