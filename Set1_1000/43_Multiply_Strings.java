class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";
        int length1 = num1.length();
        int length2 = num2.length();
        int [] position = new int [length1 + length2];
        StringBuilder sb = new StringBuilder();
        for (int i=length1-1; i>=0; i--) {
            for (int j=length2-1; j>=0; j--) {
                int multiplied = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = multiplied + position[p2]; // add with any carry
                position[p1] += sum / 10;
                position[p2] = sum % 10;
            }
        }
        for (int pos : position) {
            if (!(sb.length() == 0 && pos == 0))
                sb.append(pos);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}