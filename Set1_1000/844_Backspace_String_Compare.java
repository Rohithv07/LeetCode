// logic is to start comparing from the right end to the left end
// it is sure that, the character on the left of # will be deleted, so we can skip it easily than from left to right, this is because, from left to right, if we see a #, we cannot fix howm many characters might be deleted

class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (s.equals(t))
            return true;
        int i = s.length() - 1;
        int j = t.length() - 1;
        int countSHash = 0;
        int countTHash = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countSHash > 0 || s.charAt(i) == '#')) {
                if (s.charAt(i) == '#')
                    countSHash += 1;
                else
                    countSHash -= 1;
                i -= 1;
            }
            char left = (i < 0) ? '*' : s.charAt(i);
            while (j >= 0 && (countTHash > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') 
                    countTHash += 1;
                else
                    countTHash -= 1;
                j -= 1;
            }
            char right = (j < 0) ? '*' : t.charAt(j);
            if (left != right)
                return false;
            i -= 1;
            j -=1;
       }
        return true;
    }
}
