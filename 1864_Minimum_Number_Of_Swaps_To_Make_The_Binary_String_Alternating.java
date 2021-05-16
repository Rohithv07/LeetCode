class Solution {
    public int minSwaps(String s) {
        int length = s.length();
        if (length == 1)
            return 0;
        int countOf1 = 0;
        int countOf0 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1')
                countOf1 += 1;
            else countOf0 += 1;
        }
        if (Math.abs(countOf1 - countOf0) > 1)
            return -1;
        if (countOf1 > countOf0)
            return countOfSwaps(s, '1');
        else if (countOf0 > countOf1)
            return countOfSwaps(s, '0');
        return Math.min(countOfSwaps(s, '1'), countOfSwaps(s, '0'));
    }
    
    public int countOfSwaps(String s, char current) {
        int swaps = 0;
        for (char ch : s.toCharArray()) {
            if (ch != current) {
                swaps += 1;
            }
            if (current == '1')
                current = '0';
            else
                current = '1';
        }
        return swaps / 2;
    }
}
