class Solution {
    public String reversePrefix(String word, char ch) {
        if (word == null || word.length() == 0) {
            return "";
        }
        int length = word.length();
        if (length == 1) {
            return word;
        }
        int start = 0;
        int end = -1;
        for (int i=0; i<length; i++) {
            char current = word.charAt(i);
            if (current == ch) {
                end = i;
                break;
            }
        }
        if (end == -1) {
            return word;
        }
        String prefix = word.substring(start, end + 1);
        return reverse(prefix) + word.substring(end + 1);
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}