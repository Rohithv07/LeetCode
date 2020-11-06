class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        while (k -- > 0) {
            int previous = grid[row-1][col-1];
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    int temp = grid[i][j];
                    grid[i][j] = previous;
                    previous = temp;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int [] r: grid) {
            List<Integer> rowWise = new ArrayList<>();
            result.add(rowWise);
            for (int rows: r) {
                rowWise.add(rows);
            }
        }
        return result;
    }
}
