class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        int endRow = s.charAt(4) - '0';
        int startRow = s.charAt(1) - '0';
        char startCol = s.charAt(0) < s.charAt(3) ? s.charAt(0) : s.charAt(3);
        char endCol = s.charAt(3) < s.charAt(0) ? s.charAt(0) : s.charAt(3);
        for (char ch = startCol; ch <= endCol; ch++) {
            int index = startRow;
            while (index <= endRow) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch).append(index);
                index++;
                result.add(sb.toString());
            }
        }
        return result;
    }
}