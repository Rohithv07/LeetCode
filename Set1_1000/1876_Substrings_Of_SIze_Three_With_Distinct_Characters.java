class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() <= 2)
            return 0;
        int result = 0;
        for (int i=0; i<s.length() - 2; i++) {
            int [] count = new int [26];
            String ss= s.substring(i, i+3);
            System.out.println(ss);
            for (char ch : ss.toCharArray()) {
                count[ch - 'a'] += 1;
            }
            boolean valid = true;
            for (int number : count) {
                if (number > 1) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                result += 1;
        }
        return result;
    }
}



// efficient

class Solution {
    public int countGoodSubstrings(String s) {
        int length = s.length();
        if (length <= 2)
            return 0;
        int result = 0;
        for (int i=1; i<length - 1; i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = s.charAt(i);
            char ch3 = s.charAt(i + 1);
            if (ch1 != ch2 && ch2 != ch3 && ch3 != ch1)
                result += 1;
        }
        return result;
    }
}
