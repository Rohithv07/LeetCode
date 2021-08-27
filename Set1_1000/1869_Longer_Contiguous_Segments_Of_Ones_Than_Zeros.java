class Solution {
    public boolean checkZeroOnes(String s) {
        if (s.length() == 0 || s == null)
            return false;
        int countZero = 0;
        int countOne = 0;
        int maxZero = 0;
        int maxOne = 0;
        int length = s.length();
        int i = 0;
        while (i < length) {
            char current = s.charAt(i);
            if (current == '1') {
                while (i < length && s.charAt(i) == '1') {
                    countOne += 1;
                    i += 1;
                }
            }
            else {
                while (i < length && s.charAt(i) == '0') {
                    countZero += 1;
                    i += 1;
                }
            }
            maxZero = Math.max(maxZero, countZero);
            countZero = 0;
            maxOne = Math.max(maxOne, countOne);
            countOne = 0;
        }
        return maxZero < maxOne;
    }
}
