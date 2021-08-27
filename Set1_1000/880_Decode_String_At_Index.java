class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int length = S.length();
        for (int i=0; i<length; i++) {
            char current = S.charAt(i);
            if (Character.isDigit(current))
                size *= current - '0';
            else 
                size += 1;
        }
        for (int i = length - 1; i>=0; i--) {
            char current = S.charAt(i);
            K %= size; // this will be the required one.
            if (K == 0 && Character.isLetter(current))
                return Character.toString(current);
            if (Character.isDigit(current))
                size /= current - '0';
            else
                size -= 1;
        }
        return null;
    }
}



