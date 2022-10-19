class Solution {
    public String robotWithString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        int [] count = new int [26];
        for (char ch : s.toCharArray()) {
            count[ch -'a']++;
        }
        StringBuilder onPaper = new StringBuilder();
        // we use stack as to the paper we are taking the character for the last.
        // this means at a point that character will be the previous character that we added from string s to the string t as per the question.
        Stack<Character> robotHand = new Stack<>();
        for (char ch : s.toCharArray()) {
            robotHand.push(ch);
            count[ch - 'a']--;
            while (!robotHand.isEmpty() && robotHand.peek() < findSmallestChar(count)) {
                char toPaper = robotHand.pop();
                onPaper.append(toPaper);
            }
        }
        while (!robotHand.isEmpty()) {
            char toPaper = robotHand.pop();
            onPaper.append(toPaper);
        }
        return onPaper.toString();
    }
    
    private char findSmallestChar(int [] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char)('a' + i);
            }
        }
        return 'a';
    }
}
/*




*/