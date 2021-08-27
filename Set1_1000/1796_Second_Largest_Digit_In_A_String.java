class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                int value = current - '0';
                if (value > first) {
                    second = first;
                    first = value;
                }
                else if (second < value && value < first) {
                    second = value;
                }
            }
        }
        return second;
    }
}
