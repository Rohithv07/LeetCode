class Solution {
    public boolean checkString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int length = s.length();
        int firstOccuranceOfB = 0;
        while (firstOccuranceOfB < length && s.charAt(firstOccuranceOfB) == 'a') {
            firstOccuranceOfB++;
        }
        if (firstOccuranceOfB == length) {
            return true;
        }
        while (firstOccuranceOfB < length) {
            if (s.charAt(firstOccuranceOfB++) == 'a') {
                return false;
            }
        }
        return true;
    }
}


class Solution {
    public boolean checkString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }
}