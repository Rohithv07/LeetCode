class Solution {
    public int captureForts(int[] forts) {
        int length = forts.length;
        if (length == 0 || forts == null) {
            return 0;
        }
        int standingPointer = 0;
        int maxFort = 0;
        int movingPointer = 0;
        // counting the number of 0's between 1 and -1 or -1 and 1
        while (movingPointer < length) {
            if (forts[movingPointer] != 0) {
                if (forts[movingPointer] == -forts[standingPointer]) {
                    maxFort = Math.max(maxFort, movingPointer - standingPointer - 1);
                }
                standingPointer = movingPointer;
            }
            movingPointer++;
        }
        return maxFort;
    }
}