class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int value = x ^ y;
        while (value > 0) {
            count += value & 1;
            value >>= 1;
        }
        return count;
    }
}