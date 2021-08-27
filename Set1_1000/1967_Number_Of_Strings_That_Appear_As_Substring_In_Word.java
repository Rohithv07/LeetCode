class Solution {
    public int numOfStrings(String[] patterns, String word) {
        if (patterns == null || patterns.length == 0 || word == null || word.length() == 0)
            return 0;
        int length = patterns.length;
        int lengthWord = word.length();
        int count = 0;
        for (String pattern : patterns) {
            if (word.indexOf(pattern) < 0)
                continue;
            count += 1;
        }
        return count;
    }
}