class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        if (brokenLetters == null || brokenLetters.length() == 0) {
            String [] splittedBySpace = text.split(" ");
            return splittedBySpace.length;
        }
        boolean [] malfunctioning = new boolean [26];
        for (char ch : brokenLetters.toCharArray()) {
            malfunctioning[ch - 'a'] = true;
        }
        int countWord = 0;
        String [] splittedBySpace = text.split(" ");
        for (String splits : splittedBySpace) {
            boolean isPossible = false;
            for (char ch : splits.toCharArray()) {
                if (malfunctioning[ch - 'a']) {
                    isPossible = false;
                    break;
                }
                isPossible = true;
            }
            if (isPossible)
                countWord += 1;
        }
        return countWord;
    }
}