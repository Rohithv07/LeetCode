class Solution {
    public int countNegatives(int[][] grid) {
        int negativeCount = 0;
        if (grid.length == 0)
            return negativeCount;
        for (int i=grid.length-1; i>=0; i--) {
            for (int j=grid[i].length-1; j>=0; j--) {
                if (grid[i][j] < 0)
                    negativeCount += 1;
                else
                    break;
            }
        }
        return negativeCount;
    }
}
