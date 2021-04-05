class Solution {
    public String truncateSentence(String s, int k) {
        String [] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < k) {
            String current = splitted[index];
            sb.append(current);
            sb.append(" ");
            index += 1;
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
