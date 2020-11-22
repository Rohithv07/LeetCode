// here the theory is minimum time to connect all points is the max(x1-x2, y1-y2) summig up with all the points

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minimumTime = 0;
        int row = points.length;
        for (int i=1; i<row; i++) {
            int [] currentPoint = points[i];
            int [] previousPoint = points[i-1];
            int x1 = previousPoint[0];
            int y1 = previousPoint[1];
            int x2 = currentPoint[0];
            int y2 = currentPoint[1];
            // our answer is the max(x1-x2, y1-y2)
            minimumTime += Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
        }
        return minimumTime;
    }
}
