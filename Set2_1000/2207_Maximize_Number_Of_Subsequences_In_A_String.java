// it is always better to either put ch0 at the very beginning or ch1 at the very end to get maximum output

class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long totalSubSeqCount = 0;
        int countCh0 = 0;
        int countCh1 = 0;
        int lengthText = text.length();
        char ch0 = pattern.charAt(0);
        char ch1 = pattern.charAt(1);
        for (int i = 0; i < lengthText; i++) {
            char currentChar = text.charAt(i);
            if (currentChar == ch1) {
                totalSubSeqCount += countCh0;
                countCh1++;
            }
            if (currentChar == ch0) {
                countCh0++;
            }
        }
        return totalSubSeqCount + Math.max(countCh0, countCh1);
    }
}