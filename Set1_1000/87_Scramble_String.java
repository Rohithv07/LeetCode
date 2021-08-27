// ref : https://www.youtube.com/watch?v=MDmZm_aVDF8

class Solution {
    // memoisation
    private Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        // we make use of a stringbuilder to append both s1 and s2 in each recursive call and add to the map. If already present, we directly take the previous stored value.
        StringBuilder key = new StringBuilder();
        key.append(s1);
        key.append(s2);
        if (map.containsKey(key.toString()))
            return map.get(key.toString());
        // 1st check is to make sure both strings have same characters,otherwise we dont want to look further
        int [] count = new int [26];
        for (int i=0; i<s1.length(); i++) {
            count[s1.charAt(i) - 'a'] += 1;
            count[s2.charAt(i) - 'a'] -= 1;
        }
        for (int number : count) {
            if (number != 0) {
                map.put(key.toString(), false);
                return false;
            }
        }
        // now we need to continue our check as both the strings are anagrams
        // take i to 1 and recursively check substring(0, i) for both strings and substring(i) for both the string holds true. If yes, we continue our check
        // since we can also do flipping, the reverse case also needs to be checked.
        // ie from length - i and 0 to length - i
        // this is because flip operation is also possible 
        for (int i=1; i<s1.length(); i++) {
            // split at i for s1 and s2
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(key.toString(), true);
                return true;
            }
            // also check by splitting s1 at i and s2 at length - 1
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                map.put(key.toString(), true);
                return true;
            }
        }
        map.put(key.toString(), false);
        return false;
    }
}


// normal recursion is getting TLE so memoisation is applied using Map.
