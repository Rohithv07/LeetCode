// divide and conquer
class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray())
            set.add(ch);
        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (set.contains(Character.toUpperCase(current)) && set.contains(Character.toLowerCase(current)))
                continue;
            String str1 = longestNiceSubstring(s.substring(0, i));
            String str2 = longestNiceSubstring(s.substring(i + 1));
            return str1.length() >= str2.length() ? str1 : str2;
        }
        return s;
    }
}
