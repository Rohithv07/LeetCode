class Solution {
    public int minOperations(String s) {
        return Math.min(getFlipStartingWith(s, '0'), getFlipStartingWith(s, '1'));
    }
    
    public char flip(char ch) {
        return (ch == '0') ? '1' : '0';
    }
    
    public int getFlipStartingWith(String s, char ch) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ch)
                count += 1;
            ch = flip(ch);
        }
        return count;
    }
}
