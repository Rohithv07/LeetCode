class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int length = queries.length;
        int [] count = new int [length];
        int index = 0;
        for (int [] q : queries) {
            int centerX = q[0];
            int centerY = q[1];
            int radius = q[2];
            int countInside = 0;
            for (int [] p: points) {
                int x = p[0];
                int y = p[1];
                int check = ((x - centerX) * (x - centerX)) + ((y - centerY) * (y - centerY));
                if (check <= radius * radius)
                    countInside += 1;
            }
            count[index] = countInside;
            index += 1;
        }
        return count;
    }
}
