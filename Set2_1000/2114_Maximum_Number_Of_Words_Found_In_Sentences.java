class Solution {
    public int mostWordsFound(String[] sentences) {
        if (sentences == null || sentences.length == 0) {
            return 0;
        }
        int maxNumberOfWords = 0;
        for (String sentence : sentences) {
            int currentWordNumber = 0;
            for (char letter : sentence.toCharArray()) {
                if (letter == ' ') {
                    currentWordNumber += 1;
                }
            }
            if (maxNumberOfWords < currentWordNumber + 1) {
                maxNumberOfWords = currentWordNumber + 1;
            }
        }
        return maxNumberOfWords;
    }
}