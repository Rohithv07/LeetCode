class Solution {
    public int percentageLetter(String s, char letter) {
        int totalLength = s.length();
        int countOfLetter = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                countOfLetter ++;
            }
        }
        return (countOfLetter * 100) / totalLength;
    }
}