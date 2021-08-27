class Solution {
    public boolean isIsomorphic(String s, String t) {
        int wordIndex [] = new int [256];
        int patternIndex [] = new int [256];
        for (int i=0; i<Math.min(s.length(), t.length()); i++) {
            if (wordIndex[s.charAt(i)] != patternIndex[t.charAt(i)])
                return false;
            wordIndex[s.charAt(i)] = i + 1;
            patternIndex[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
