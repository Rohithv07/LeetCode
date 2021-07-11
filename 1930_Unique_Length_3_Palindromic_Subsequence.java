class Solution {
    public int countPalindromicSubsequence(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int count = 0;
        // we need to find the first and last oocurance of each charcater
        // now our problem reduced to finding the distint charcaters between these fixed characters
        int [] firstOccurance = new int [26];
        int [] finalOccurance = new int [26];
        Arrays.fill(firstOccurance, -1);
        Arrays.fill(finalOccurance, -1);
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (firstOccurance[ch - 'a'] == -1) {
                // ie this index is the first occurance of ch
                firstOccurance[ch - 'a'] = i;
            }
            finalOccurance[ch - 'a'] = i;
        }
        // only needed the distinct characters in between
        // so a set or boolean array is needed to mark visited
        boolean [] visited;
        for (int i=0; i<26; i++) {
            int firstIndex = firstOccurance[i];
            int finalIndex = finalOccurance[i];
            visited = new boolean [26];
            for (int j=firstIndex + 1; j<finalIndex; j++) {
                if (!visited[s.charAt(j) - 'a']) {
                    count += 1;
                    visited[s.charAt(j) - 'a'] = true;
                }
            }
        }
        return count;
    }
}