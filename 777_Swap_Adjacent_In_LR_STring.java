class Solution {
    public boolean canTransform(String start, String end) {
        // if there are no X, then the two string must be equal
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < start.length() && pointer2 < end.length()) {
            // increment p1 and p2 whenever we see X from the position
            // this is to get the nonX positions
            while (pointer1 < start.length() && start.charAt(pointer1) == 'X') {
                pointer1 += 1;
            }
            while (pointer2 < end.length() && end.charAt(pointer2) == 'X') {
                pointer2 += 1;
            }
            // if both the pointer reaches the end of the strings, then we can return true.
            // if only one of the pointer reaches the end of the strings, then we can return false
            if (pointer1 == start.length() && pointer2 == end.length())
                return true;
            if (pointer1 == start.length() || pointer2 == end.length())
                return false;
            // if the characyer at respective pointer1 and pointer2 of start and end is not equal, then we cannot transform
            if (start.charAt(pointer1) != end.charAt(pointer2))
                return false;
            // if the pointer1 at the start points to the 'L' and pointer2 > pointer1 return false
            // this is because L can be only moved to the left and pointer1 must be > pointer2
            // if the pointer2 at the end points to the 'R' and pointer1 > pointer2 return false
            // this is because R can be only moved to the right and pointer2 must be > pointer1
            if (start.charAt(pointer1) == 'L' && pointer2 > pointer1)
                return false;
            if (end.charAt(pointer2) == 'R' && pointer1 > pointer2)
                return false;
            pointer1 += 1;
            pointer2 += 1;
        }
        return true;
    }
}
