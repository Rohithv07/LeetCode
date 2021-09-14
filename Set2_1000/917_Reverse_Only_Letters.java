class Solution {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int left = 0;
        int right = length - 1;
        char [] converted = s.toCharArray();
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            //System.out.println(Character.isLetter(leftChar) + " " + Character.isLetter(rightChar));
            if (Character.isLetter(leftChar) && Character.isLetter(rightChar)) {
                swap(converted, left, right);
                left++;
                right--;
            }
            else if (!Character.isLetter(leftChar) && !Character.isLetter(rightChar)) {
                left++;
                right--;
            }
            else if(!Character.isLetter(leftChar)) {
                left++;
            }
            else if (!Character.isLetter(rightChar)) {
                right--;
            }
        }
        return new String(converted);
    }
    
    private void swap(char [] converted, int i, int j) {
        char temp = converted[i];
        converted[i] = converted[j];
        converted[j] = temp;
    }
}