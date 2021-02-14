// check if the slope for all the points are same or not.
// same return true;
// not same return false;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int row = coordinates.length;
        int col = coordinates[0].length;
        if (row == 2)
            return true;
        int x = coordinates[0][0];
        int y1 = coordinates[1][1];
        int x1 = coordinates[1][0];
        int y = coordinates[0][1];
        int diffX = x1 - x;
        int diffY = y1 - y;
        for (int [] points : coordinates) {
            int currentX = points[0];
            int currentY = points[1];
            if (diffX * (currentY - y1) != diffY * (currentX - x1))
                return false;
        }
        return true;
    }
}
