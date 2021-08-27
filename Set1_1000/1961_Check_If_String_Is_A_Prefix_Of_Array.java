class Solution {
    public boolean isPrefixString(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return false;
        int indexOfS = 0;
        for (int i=0; i<words.length && indexOfS < s.length(); i++) {
            for (char ch : words[i].toCharArray()) {
                if (indexOfS == s.length() || ch != s.charAt(indexOfS++))
                    return false;
            }
        }
        return indexOfS == s.length();
    }
}