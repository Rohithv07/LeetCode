class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        return (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }
}


class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        return (n & (n - 1)) == 0;
    }
}