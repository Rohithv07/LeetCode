class Solution {
    public String replaceDigits(String s) {
        if (s.length() == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length() - 1; i+=2) {
            char first = s.charAt(i);
            sb.append(first);
            int second = Integer.valueOf(s.charAt(i + 1)) - '0';
            System.out.println(second);
            for (int j=0; j<second; j++) {
                first += 1;
                //System.out.println(first);
            }
            sb.append(first);
        }
        if (sb.length() != s.length()) {
            sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }
}
