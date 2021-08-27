class Solution {
    public String longestPrefix(String s) {
        int length = s.length();
        int [] store = new int [length];
        for (int i=1; i<length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (s.charAt(i) == s.charAt(store[j])) {
                    store[i] = store[j] + 1;
                    break;
                }
                else {
                    j = store[j] - 1;
                }
            }
        }
        return s.substring(0, store[length - 1]);
        // the max length will be store[length - 1]
    }
}
