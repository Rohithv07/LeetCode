class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int [] interval: intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                count += 1;
            }
        }
        return intervals.length - count;
    }
}
