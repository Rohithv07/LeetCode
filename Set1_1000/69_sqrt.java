class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 1;
        int high = x;
        int squareRoot = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (middle <= x / middle) {
                low = middle + 1;
                squareRoot = middle;
            }
            else {
                high = middle - 1;
            }
        }
        return squareRoot;
    }
}