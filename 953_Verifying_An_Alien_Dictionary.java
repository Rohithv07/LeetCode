// the right most must be bigger than  the left
// and for the left most string, it must be the smallest wrt right

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] map = new int [26];
        // mapping according to the alien dictionary
        for (int i=0; i<order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i=1; i<words.length; i++) {
            String previous = words[i - 1];
            String current = words[i];
            if (isPreviousBigger(previous, current, map)) {
                // this returns true when previous > current which says it will not be sorted
                return false;
            }
        }
        return true;
    }
    
    public boolean isPreviousBigger(String s1, String s2, int [] map) {
        int length1 = s1.length();
        int length2 = s2.length();
        for (int i=0; i<length1 && i<length2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a'];
            }
        }
        return length1 > length2;
    }
}
