class Solution {
    public int minKBitFlips(int[] A, int K) {
        int length = A.length;
        // a boolean array to close the interval;
        boolean [] close = new boolean[length];
        int answer = 0;
        int numberOfIntervals = 0;
        for (int i=0; i<length; i++) {
            // if close[i] = true, then we nneed to close it
            if (close[i])
                numberOfIntervals -= 1;
            // we flip based on 2 conditions
            // 1. if A[i] = 0 and numberOfIntervals = even or
            // 2. if A[i] = 1 and numberOfIntervals = odd
            if ((A[i] == 0 && numberOfIntervals % 2 == 0) || (A[i] == 1 && numberOfIntervals % 2 != 0)) {
                answer += 1;
                // also generate a interval
                numberOfIntervals += 1;
                if (i > length - K)
                    return -1;
                if (i + K < length)
                    close[i+K] = true;
            }
        }
        return answer;
    }
}


// https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
