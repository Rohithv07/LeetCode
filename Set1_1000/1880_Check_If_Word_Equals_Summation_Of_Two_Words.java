class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        int length1 = firstWord.length();
        int length2 = secondWord.length();
        int length3 = targetWord.length();
        for (char ch : firstWord.toCharArray()) {
            int temp = ch - 'a';
            value1 += (temp * (int)(Math.pow(10, length1 - 1)));
            length1 -= 1;
        }
        for (char ch : secondWord.toCharArray()) {
            int temp = ch - 'a';
            value2 += (temp * (int)(Math.pow(10, length2 - 1)));
            length2 -= 1;
        }
        for (char ch : targetWord.toCharArray()) {
            int temp = ch - 'a';
            value3 += (temp * (int)(Math.pow(10, length3 - 1)));
            length3 -= 1;
        }
        return value1 + value2 == value3;
    }
}
