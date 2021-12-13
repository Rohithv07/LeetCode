class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String [] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=split.length-1; i>=0; i--) {
            String current = split[i];
            if (!current.equals("")) {
                sb.append(current);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        String reversed = sb.toString();
        System.out.println(reversed);
        return reversed;
    }
}