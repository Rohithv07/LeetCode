class Solution {
    public boolean checkRecord(String s) {
        if (s.length() == 1)
            return true;
        int countOfAbsent = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == 'A') {
                countOfAbsent += 1;
            }
            else if (s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                return false;
        }
        for (int i = s.length() - 2; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                countOfAbsent += 1;
        }
        return countOfAbsent > 1 ? false : true;
    }
}
