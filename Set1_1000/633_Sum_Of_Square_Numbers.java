class Solution {
    public boolean judgeSquareSum(int c) {
        if (c <= 2)
            return true;
        int low = 0;
        int high = (int)Math.sqrt(c);
        while (low <= high) {
            int square = low * low + high * high;
            if (square == c)
                return true;
            if (square > c) {
                high--;
            }
            else {
                low++;
            }
        }
        return false;
    }
}

/*
1 2 3
1*1 + 2*2
2 * 2 + 3 * 3


*/