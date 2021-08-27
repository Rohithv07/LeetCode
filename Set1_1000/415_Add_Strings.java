class Solution {
    public String addStrings(String num1, String num2) {
        if ((num1 == null || num1.length() == 0) && (num2 == null || num2.length() == 0))
            return "";
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            i--; j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
        
    }
}