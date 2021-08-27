class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isAMatch(word, pattern))
                result.add(word);
        }
        return result;
    }
    
    public boolean isAMatch(String word, String pattern) {
        int [] wordIteration = new int [26];
        int [] patternIteration = new int [26];
        for (int i=0; i<Math.min(word.length(), pattern.length()); i++) {
            if (wordIteration[word.charAt(i) - 'a'] != patternIteration[pattern.charAt(i) - 'a'])
                return false;
            wordIteration[word.charAt(i) - 'a'] = i + 1;
            patternIteration[pattern.charAt(i) - 'a'] = i + 1;
        }
        return true;
    }
}
