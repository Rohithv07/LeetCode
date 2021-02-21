class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();
        int left = 0;
        int right = 0;
        while (left < length1 || right < length2) {
            if (left < length1) {
                sb.append(word1.charAt(left));
                left += 1;
            }
            if (right < length2) {
                sb.append(word2.charAt(right));
                right += 1;
            }
        }
        return sb.toString();
    }
}
