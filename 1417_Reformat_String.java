// 1. Create two list for numbers and characters each.
// 2. If the diff between these two list is >= 2, return "" as we cant get any answer.
// 3. Use a boolean variable to switch between digit and characters.
// 4. Always start the first letter with the max count one, ie max(digit, letter) count

class Solution {
    public String reformat(String s) {
        List<Character> digit = new ArrayList<>();
        List<Character> letter = new ArrayList<>();
        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch))
                digit.add(ch);
            else
                letter.add(ch);
        }
        if (Math.abs(digit.size() - letter.size()) >= 2)
            return "";
        StringBuilder sb = new StringBuilder();
        boolean isNumber = (digit.size() - letter.size() < 0) ? false : true;  // here i actuallu checks for the maximum size from the two.
        for (int i=0; i<s.length(); i++) {
            if (isNumber) {
                if (digit.size() > 0) {
                    sb.append(digit.remove(0));
                    
                }
            }
            else {
                if (letter.size() > 0)
                    sb.append(letter.remove(0));
            }
            isNumber = !isNumber;
        }
        return sb.toString();
    }
}
