/*
My thought process:
So for most of the intervals problem, the first basic thing we need to do is to sort the intervals based on the 1st values of each interval.
After sorting, we can think of situation when the intervals will overlapp.
            [1, 3] [2, 6]. So here we can see they overlapp as if we look at a number line
               1 2 3 4 5 6, we can surely see that they overlap.
               
So the condition for overlapp is to check whether statring of 2nd interval <= end of 1st interval.
If it is like that, then we update the end of the interval with the maximum(currentEnd or nextEnd)
Otherwise just add them to the output and repeat the process.
Thats the whole problem.
*/


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); // sorts based on the first number in interval
        List<int [] > output = new ArrayList<>();
        int [] current = intervals[0];
        output.add(current);    // we first of all add the first interval
        for (int [] interval: intervals) { // go through each intervals
            int currentBeg = current[0];
            int currentEnd = current[1];
            int nextBeg = interval[0];
            int nextEnd = interval[1];
            if (nextBeg <= currentEnd) { // check if the last element of 1st interval >= first element of 2nd interval, then there is overlapping
                current[1] = Math.max(currentEnd, nextEnd);
            }
            else { // no overlapping of intervals
                current = interval;
                output.add(current);
            }
        }
        return output.toArray(new int [output.size()][]);
    }
}
