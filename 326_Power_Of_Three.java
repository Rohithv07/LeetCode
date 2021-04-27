class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
