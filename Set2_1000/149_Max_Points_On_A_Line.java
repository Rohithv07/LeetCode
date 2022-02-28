class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int same = 0;
            int count = 1;
            Map<Double, Integer> slopeTracker = new HashMap<>();
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    if (x1 == x2 && y1 == y2) {
                        same++;
                        continue;
                    }
                    if (x1 == x2) {
                        count++;
                        continue;
                    }
                    double slope = (double)(y2 - y1) / (double)(x2 - x1);
                    slopeTracker.put(slope, slopeTracker.getOrDefault(slope, 1) + 1);
                    result = Math.max(result, slopeTracker.get(slope) + same);
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}