class Solution {
    public int repeatedStringMatch(String a, String b) {
        int result = 1;
        StringBuilder sb = new StringBuilder(a);
        int lengthB = b.length();
        for (; sb.length() < lengthB; result++) {
            sb.append(a);
        }
        if (sb.indexOf(b) >= 0)
            return result;
        if (sb.append(a).indexOf(b) >= 0)
            return result + 1;
        return -1;
    }
}
