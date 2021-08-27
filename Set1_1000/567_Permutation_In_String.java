class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int [] count = new int [26];
        for (char ch : s1.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        int counterNotEqualZero = 0;
        for (int number : count) {
            if (number != 0)
                counterNotEqualZero += 1;
        }
        int start = 0;
        int end = 0;
        int lengthS1 = s1.length();
        int lengthS2 = s2.length();
        while (end < lengthS2) {
            char current = s2.charAt(end);
            count[current - 'a'] -= 1;
            if (count[current - 'a'] == 0)
                counterNotEqualZero -= 1;
            end += 1;
            while (counterNotEqualZero == 0) {
                char leftMost = s2.charAt(start);
                count[leftMost - 'a'] += 1;
                if (count[leftMost - 'a'] > 0)
                    counterNotEqualZero += 1;
                if (end - start == lengthS1)
                    return true;
                start += 1;
            }
        }
        return false;
    }
}