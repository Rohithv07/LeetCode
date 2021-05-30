class Solution {
    public String maxValue(String s, int x) {
        int length = s.length();
        for (int i=0; i<length; i++) {
            if ((s.charAt(0) != '-' && s.charAt(i) - '0' < x) || (s.charAt(0) == '-' && s.charAt(i) - '0' > x))
                return s.substring(0, i) + x + s.substring(i);
        }
        return s + x;
    }
}
