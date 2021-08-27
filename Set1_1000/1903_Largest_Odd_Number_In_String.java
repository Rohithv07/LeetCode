// traverse from back and find the odd digit
// then from 0 to this index substring will be our answer

class Solution {
    public String largestOddNumber(String num) {
        if (num == null || num.length() == 0)
            return "";
        int lastOddIndex = -1;
        int length = num.length();
        int j = length - 1;
        while (j >= 0) {
            int number = num.charAt(j) - '0';
            if (number % 2 != 0) {
                lastOddIndex = j;
                break;
            }
            j--;
        }
        return lastOddIndex == -1 ? "" : num.substring(0, j+1);
    }
}
