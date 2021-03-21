class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int irregularity = 0;
        int [] count = new int [26];
        if (s1.length() != s2.length())
            return false;
        for (int i=0; i<s1.length(); i++) {
            count[s1.charAt(i) - 'a'] += 1;
            count[s2.charAt(i) - 'a'] -= 1;
            if (s1.charAt(i) != s2.charAt(i)) 
                irregularity++;
        }
        for (int number : count) {
            if (number != 0)
                return false;
        }
        return irregularity == 2 || irregularity == 0 ? true : false;
    }
}
