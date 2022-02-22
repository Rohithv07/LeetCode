class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        int length = s.length();
        int optionToOpen = 0;
        int noOptionToClose = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                optionToOpen += 1;
            }
            else {
                noOptionToClose += 1;
            }
            if (noOptionToClose > optionToOpen) {
                return false;
            }
        }
        int optionToClose = 0;
        int noOptionToOpen = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                optionToClose += 1;
            }
            else {
                noOptionToOpen += 1;
            }
            if (noOptionToOpen > optionToClose) {
                return false;
            }
        }
        return true;
    }
}