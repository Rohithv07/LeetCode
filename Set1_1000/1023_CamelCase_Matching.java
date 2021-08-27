class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String q: queries) {
            result.add(queryMatchesPattern(q, pattern));
        }
        return result;
    }
    
    public boolean queryMatchesPattern(String word, String pattern) {
        int matchingCount = 0;
        for (char ch : word.toCharArray()) {
            if (matchingCount < pattern.length() && ch == pattern.charAt(matchingCount)) {
                matchingCount += 1;
            }
            else if (ch < 'a') {
                return false;
            }
        }
        return matchingCount == pattern.length();
    }
}
