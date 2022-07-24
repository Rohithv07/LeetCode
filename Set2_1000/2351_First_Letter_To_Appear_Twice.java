class Solution {
    public char repeatedCharacter(String s) {
        int [] count = new int [26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
            if (count[ch - 'a'] == 2) {
                return ch;
            }
        }
        return '#';
    }
}