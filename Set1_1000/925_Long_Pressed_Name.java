class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int length1 = name.length();
        int length2 = typed.length();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            char a = name.charAt(i);
            char b = typed.charAt(j);
            if (a != b)
                return false;
            while (i < length1 && j < length2 && name.charAt(i) == a && typed.charAt(j) == b) {
                i ++;
                j ++;
            }
            while (j < length2 && typed.charAt(j) == b) {
                j ++;
            }
        }
        if (i == length1 && j != length2 || i != length1 && j == length2)
            return false;
        return true;
    }
}
