// we split the string or divide the string when we see a count < k
class Solution {
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }
    public int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k)
            return 0;
        int [] count = new int [26];
        for (int i=start; i<end; i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i=0; i<26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j=start; j<end; j++) {
                    if (s.charAt(j) == i + 'a') {
                        int left = divideAndConquer(s, start, j, k);
                        int right = divideAndConquer(s, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
