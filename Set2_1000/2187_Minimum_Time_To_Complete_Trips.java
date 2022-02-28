class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // if (time.length == 1) {
        //     return time[0] * totalTrips;
        // }
        int length = time.length;
        long left = 0;
        long right = (long)1e14;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (timeTaken(time, middle) >= totalTrips) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return left;
    }
    
    public long timeTaken(int [] time, long threshold) {
        long count = 0;
        for (int t : time) {
            count += (threshold / t);
        }
        return count;
    }
}