class Solution {
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int halfCount = 0;
        int halfLength = length / 2;
        for (int i=0; i<length; i++) {
            if (i < halfLength && set.contains(s.charAt(i)))
                halfCount += 1;
            else if (i >= halfLength && set.contains(s.charAt(i)))
                halfCount -= 1;
        }
        return halfCount == 0;
    }
}
