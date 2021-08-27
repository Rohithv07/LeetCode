class Solution {
    public boolean makeEqual(String[] words) {
        if (words == null || words.length == 0)
            return false;
        int length = words.length;
        StringBuilder together = new StringBuilder();
        for (String word : words) {
            together.append(word);
        }
        int [] count = new int [26];
        for (char ch : together.toString().toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (int number : count) {
            if (number != 0 && number % length != 0)
                return false;
        }
        return true;
    }
}
