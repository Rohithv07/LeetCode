class Solution {
    public int countLatticePoints(int[][] circles) {
        int count = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int [] circle : circles) {
                    int x = circle[0];
                    int y = circle[1];
                    int r = circle[2];
                    if (isInside(x, i, y, j, r)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    
    public boolean isInside(int x1, int x2, int y1, int y2, int r) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r * r;
    }
}