class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0)
            return -1;
        boolean [] visited = new boolean [24 * 60];
        for (String point : timePoints) {
            String [] time = point.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            if (visited[hour * 60 + minute])
                return 0;
            visited[hour * 60 + minute] = true;
        }
        int minimum = Integer.MAX_VALUE;
        int previous = 0;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i=0; i<24*60; i++) {
            if (visited[i]) {
                if (first != Integer.MAX_VALUE) {
                    minimum = Math.min(minimum, i - previous);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                previous = i;
            }
        }
        minimum = Math.min(minimum, (24 * 60 - last + first));
        return minimum;
    }
}