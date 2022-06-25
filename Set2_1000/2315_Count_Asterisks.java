class Solution {
    public int countAsterisks(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int count = 0;
        boolean start = false;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '|' && !start) {
                start = true;
            }
            else if (ch == '|' && start) {
                start = false;
            }
            else if (ch == '*' && !start) {
                count++;
            }
        }
        return count;
    }
}