class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        if (s == null || s.length() == 0 || repeatLimit < 0) {
            return "";
        }
        int [] count = new int [26];
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) {
                continue;
            }
            int repeat = 0;
            while (count[i] > 0 && repeat < repeatLimit) {
                sb.append((char)(i + 'a'));
                count[i]--;
                repeat += 1;
            }
            if (count[i] == 0) {
                continue;
            }
            // next smaller finder
            for (repeat = i - 1; repeat >= 0 && count[repeat] == 0; repeat--);
            if (repeat == -1) {
                // no more characters to add
                return sb.toString();
            }
            // else we have a character to add, and just consider adding only a single character from it
            sb.append((char)(repeat + 'a'));
            count[repeat] -= 1;
            i++;
        }
        return sb.toString();
    }
}