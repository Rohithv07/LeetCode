// if there is only single element, then the value will be true as last element is 0 always
// if the last two is 0, then also it is true
// if we have 1 before the last 0, we count the number of sequential 1 and if odd, its false, otherwise true


class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0)
            return false;
        int length = bits.length;
        int countOne = 0;
        for (int i=length-2; i>=0 && bits[i] != 0; i--) {
            countOne++;
        }
        return countOne % 2 == 0;
    }
}