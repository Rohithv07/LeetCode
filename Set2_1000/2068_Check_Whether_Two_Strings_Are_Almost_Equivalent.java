class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int [] count1 = new int [26];
        int [] count2 = new int [26];
        for (char ch : word1.toCharArray()) {
            count1[ch - 'a'] += 1;
        }
        for (char ch : word2.toCharArray()) {
            count2[ch - 'a'] += 1;
        }
        for (int i=0; i<26; i++) {
            int freq1 = count1[i];
            int freq2 = count2[i];
            if (Math.abs(freq1 - freq2) > 3) {
                return false;
            }
        }
        return true;
    }
}


// can also do with a single count array