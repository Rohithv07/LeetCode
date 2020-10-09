// so the idea here is to first count the frequency of all charcaters present inside the given input text.
// then we take the frequency.
// until our resulting string < len(input string)
    // first we go from a - > z and check whther we have a frequency > 0, if yes, then we uodate our result and decrease the frequency.
    // same way, we do z -> a and check the same as above and append to the result.
// finally this result will give us the answe according to the algorithm provided in the question.

class Solution {
    public String sortString(String s) {
        int [] freq = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i=0; i<26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] -= 1;
                }
            }
            for (int i=25; i>=0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] -= 1;
                }
            }
        }
        return sb.toString();
    }
}
