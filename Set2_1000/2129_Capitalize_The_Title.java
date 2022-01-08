class Solution {
    public String capitalizeTitle(String title) {
        if (title == null || title.length() == 0) {
            return "";
        }
        String lowerTitle = title.toLowerCase();
        String [] split = lowerTitle.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.length() <= 2) {
                sb.append(s);
            }
            else {
                char firstChar = s.charAt(0);
                sb.append(Character.toUpperCase(firstChar));
                for (int i=1; i<s.length(); i++) {
                    sb.append(s.charAt(i));
                }
            }
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}