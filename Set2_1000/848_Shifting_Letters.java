class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        char [] converted = s.toCharArray();
        for (int i=length-1; i>=0; i--) {
            if (i == length - 1) {
                shifts[i] %= 26;
            }
            else {
                shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
            }
            converted[i] = (char)('a' + (converted[i] - 'a' + shifts[i]) % 26);
        }
        return new String(converted);
    }
}