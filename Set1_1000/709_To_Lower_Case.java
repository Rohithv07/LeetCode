class Solution {
    public String toLowerCase(String s) {
        if (s.length() == 0)
            return "";
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 65 && ch <= 90) {
                sb.append((char)(ch + 32));
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
