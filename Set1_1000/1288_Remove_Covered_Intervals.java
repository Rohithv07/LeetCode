/*
Imagine that, after removing all covered intervals,
all intervals must have different bounds,
After sorting, their left and right bound are increasing at the same time.


Test Case
Here are some useful small test cases for debugging.
[[1,2],[1,3]]
[[1,3],[1,8],[5,8]]
[[1,6],[4,6],[4,8]]


Solution 1, sort
Sort the array, and note the previous left and right bound.
For evert interval v,
if v[0] > left && v[1] > right,
It's a new uncovered interval,
so we increment ++res.
*/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int result = 0;
        int left = -1;
        int right = -1;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for (int [] v: intervals) {
            if (v[0] > left && v[1] > right) {
                result += 1;
                left = v[0];
            }
            right = Math.max(right, v[1]);
        }
        return result;
    }
}
