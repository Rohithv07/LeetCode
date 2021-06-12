class Solution {
    public int minFlips(String s) {
        int length = s.length();
        int flips = Integer.MAX_VALUE;
        int mismatch = 0;
        for (int i=0; i<2*length; i++) {
            int index = i % length;
            if (s.charAt(index) - '0' != (i % 2 == 0 ? 1 : 0))
                mismatch += 1;
            if (i >= length && s.charAt(index) - '0' != (index % 2 == 0 ? 1 : 0))
                mismatch -= 1;
            if (i >= length - 1)
                flips = Math.min(flips, Math.min(mismatch, length - mismatch));
        }
        return flips;
    }
}
