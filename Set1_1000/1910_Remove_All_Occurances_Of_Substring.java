class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        for (char ch :  s.toCharArray()) {
            sb.append(ch);
            int start = sb.length() - part.length();
            if (sb.length() >= part.length() && sb.substring(start).equals(part)) {
                sb.delete(start, start + part.length());
                // delete(startPosition, endPosition)
            }
        }
        return sb.toString();
    }
}

// O(n * k) - ref https://www.youtube.com/watch?v=9OAA38ymTGo
