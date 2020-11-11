class Solution {
    public String decodeString(String s) {
        // we need 2 stacks, 1 to track the count and the other to keep track of the string
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        // now traverse throught the given string and do different operations based on
        // 1. Digit
        // 2. Open square
        // 3. Closed squre
        // 4. Letter
        int index = 0;
        String finalResult = "";
        while (index < s.length()) {
            // if digit
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                // until the digit ends just have a look on it
                while (Character.isDigit(s.charAt(index))) {
                    // update count
                    count = count * 10 + (s.charAt(index) - '0');
                    index += 1;
                }
                // now push the count to counts stack
                counts.push(count);
            }
            // if open square
            else if (s.charAt(index) == '[') {
                // push the res to the result
                result.push(finalResult);
                finalResult = "";
                index += 1; 
                
            }
            // if closed square
            else if (s.charAt(index) == ']') {
                // now we need to create the string based on the count
                StringBuilder sb = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i=0; i<count; i++) {
                    sb.append(finalResult);
                }
                finalResult = sb.toString();
                index += 1;
                
            }
            // if letter
            else {
                // if its letter just append with final reuslt
                finalResult += s.charAt(index);
                index += 1;
            }
        }
        return finalResult;
    }
}
