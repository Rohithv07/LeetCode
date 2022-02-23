class Solution {
    public String addSpaces(String s, int[] spaces) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int trackingString = 0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int space : spaces) {
            boolean isWeReachSpaceIndex = false;
            while (trackingString < length && !isWeReachSpaceIndex) {
                if (trackingString == space) {
                    sb.append(" ");
                    isWeReachSpaceIndex = true;
                }
                else {
                    sb.append(s.charAt(trackingString++));
                }
            }
        }
        while (trackingString < length) {
                sb.append(s.charAt(trackingString++));
        }
        return sb.toString();
    }
}