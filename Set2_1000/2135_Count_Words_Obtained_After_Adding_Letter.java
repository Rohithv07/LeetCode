// We sort and add start words to a hash set. We also sort each target word, and remove a character from each position. If a string - with the removed character - can be located in the hash set, then we can obtain the target word.

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> store = new HashSet<>();
        for (String word : startWords) {
            char [] ch = word.toCharArray();
            Arrays.sort(ch);
            store.add(new String(ch));
        }
        int result = 0;
        for (String word : targetWords) {
            char [] ch = word.toCharArray();
            Arrays.sort(ch);
            word = new String(ch);
            for (int i=0; i<word.length(); i++) {
                if (store.contains(word.substring(0, i) + word.substring(i + 1))) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}