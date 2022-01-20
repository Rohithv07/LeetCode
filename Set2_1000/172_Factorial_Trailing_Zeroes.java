class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        if (n == 5) {
            return 1;
        }
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}