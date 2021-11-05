class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        int completelyFilled = 0;
        int runningCoins = 0;
        while (n > 0 && n > completelyFilled) {
            completelyFilled += 1;
            n -= completelyFilled;
        }
        return completelyFilled;
    }
}