class Solution {
    public String largestMerge(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return s1 + s2;
        if (s1.compareTo(s2) > 0) {
            return s1.charAt(0) + largestMerge(s1.substring(1), s2);
        }
        return s2.charAt(0) + largestMerge(s1, s2.substring(1));
    }
}

/*
The idea is
-> compare the character of both word
-> if one character > the other one, just chose the greater one as we need lexicographically greatest.
-> Now the case to consider is when we have same characcters on both end.
-> for eg : s1 = aaap  s2 = aaaz  Here for s1 and s2 have a equal and they differ in the last possititon
-> But we need to consider z then only p as z lexicographically greater than p.
-> this is the special case to consider in this case.
-> With the help of compareTo, it make possible to chose z before p in this question and recursively repeat the process;
*/
