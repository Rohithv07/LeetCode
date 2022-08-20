class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char [] toChar = s.toCharArray();
        int length = s.length();
        int count = 0;
        while (true) {
            boolean isFound = false;
            for (int i = 0; i + 1 < length;) {
                char current = toChar[i];
                char next = toChar[i + 1];
                if (current == '0' && next == '1') {
                    toChar[i] = '1';
                    toChar[i + 1] = '0';
                    i += 2;
                    isFound = true;
                }
                else {
                    i += 1;
                }
            }
            if (!isFound) {
                return count;
            }
            count++;
        }
    }
}