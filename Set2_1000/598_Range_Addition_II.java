class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0)
            return m * n;
        int row = m;
        int col = n;
        for (int [] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }
        return row * col;
    }
}