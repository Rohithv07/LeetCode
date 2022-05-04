// O(26 * n)

class Solution {
    public long appealSum(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        long appeal = 0;
        int [] last = new int [26];
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            last[ch - 'a'] = i + 1;
            for (int index : last) {
                appeal += index;
            }
        }
        return appeal;
    }
}

// O(n)

class Solution {
    public long appealSum(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        long appeal = 0;
        long total = 0;
        int [] last = new int [26];
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            total += (i + 1) - (last[ch - 'a']);
            last[ch - 'a'] = i + 1;
            appeal += (total);
        }
        return appeal;
    }
}