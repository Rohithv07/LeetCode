//startsWith() method is used to check for the prefix of a word.

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.length() == 1 && !sentence.equals(searchWord))
            return -1;
        String [] array = sentence.split(" ");
        for(int i=1; i<=array.length; i++) {
            if (array[i-1].startsWith(searchWord))
                return i;
        } 
        return -1;
    }
}
