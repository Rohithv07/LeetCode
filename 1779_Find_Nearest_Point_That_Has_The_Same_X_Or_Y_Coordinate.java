class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int distance = Integer.MAX_VALUE;
        for (int i=0; i<points.length; i++) {
            int diffX = x - points[i][0];
            int diffY = y - points[i][1];
            int manhattanDistance = Math.abs(diffX) + Math.abs(diffY);
            if (diffX * diffY == 0 && manhattanDistance < distance) {
                distance = manhattanDistance;
                index = i;
            }
        }
        return index;
    }
}
