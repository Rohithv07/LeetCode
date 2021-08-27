class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        if (s == null || s.length() == 0)
            return 0;
        // we meed to binary search for the k which need to be removed
        char [] convertedS = s.toCharArray();
        int left = 0;
        int right = removable.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            //int middle = left + (right - left) / 2;
            // remove letters from 0 to mid by changing it into someother non letters
            for (int i=0; i<=middle; i++) {
                convertedS[removable[i]] = '?';
            }
            // if it is still subsequence change left boundary 
            // else replace all eremoved ones and change right boumndary
            if (isSubsequence(convertedS, p)) {
                left = middle + 1;
            }
            else {
                for (int i=0; i<=middle; i++) {
                    convertedS[removable[i]] = s.charAt(removable[i]);
                }
                right = middle - 1;
            }
        }
        return left;
    }
    
    // simple check for subsequence
    public boolean isSubsequence(char [] convertedS, String p) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < convertedS.length && p2 < p.length()) {
            if (convertedS[p1] != '?' && convertedS[p1] == p.charAt(p2))
                p2 += 1;
            p1 += 1;
        }
        return p2 == p.length();
    }
}

// sb.deleteCharAt(3) -> sb.indexOf(3) >= 0 
//sb.deleteCharAt(1) -> sb.indexOf(1) >= 0
