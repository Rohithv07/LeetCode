


Solution:

//my initial idea is to use the concept of merging the intervals started by sorting the points based on the second number.
//then just look whtegr the start > end

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        // sort the elements based on the second element
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        // lets have a varible for storing the result
        int arrowCount = 0;
        long possibleEnd = Long.MIN_VALUE;
        for (int [] p: points) {
            // check if the start > end, then updaye the end by next, ie here p[1] and increment the count.
            if (p[0] > possibleEnd) {
                possibleEnd = p[1];
                arrowCount += 1;
            }
        }
        return arrowCount;
    }
}
