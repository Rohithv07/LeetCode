class Solution {
    public String sortSentence(String s) {
        String [] split = s.split(" ");
        String [] sorted = new String [10];
        for (String str : split) {
            int length = str.length();
            char ch = str.charAt(length - 1);
            int index = ch - '0';
            sorted[index] = str.substring(0, length - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : sorted) {
            if (str != null) {
                sb.append(str);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
