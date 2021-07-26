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


class Solution {
    public boolean isPowerOfTwo(int num) {
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        int x = 1;
        int count = 0;
        while (num > 0) {
            int value = num & x;
            if (value == 1)
                count += 1;
            num = num >> 1;
        }
        return count == 1;
    }
}