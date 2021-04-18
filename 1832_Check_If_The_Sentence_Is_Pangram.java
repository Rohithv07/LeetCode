class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26)
            return false;
        int [] count = new int [26];
        for (char ch : sentence.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (int number : count) {
            if (number == 0)
                return false;
        }
        return true;
    }
}
