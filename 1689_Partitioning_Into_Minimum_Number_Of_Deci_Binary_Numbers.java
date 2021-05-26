class Solution {
    public int minPartitions(String n) {
        if (n.length() == 0 || n == null)
            return -1;
        int maxDigit = 0;
        for (char ch :  n.toCharArray()) {
            int currentDigit = ch - '0';
            maxDigit = Math.max(maxDigit, currentDigit);
        }
        return maxDigit;
    }
}
