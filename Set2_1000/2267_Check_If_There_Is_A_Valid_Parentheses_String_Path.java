class Solution {
    public boolean hasValidPath(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = row + col - 2;
        // i j count
        Boolean [][][] visited = new Boolean [row + 1][col + 1][max + 1];
        //visited[0][0][0] = true;
        return dfs(grid, 0, 0, 0, visited, row, col, max);
    }
    
    private boolean dfs(char [][] grid, int startRow, int startCol, int balanceCount, Boolean [][][] visited, int row, int col, int max) {
        // out of bounds
        if (startRow >= row || startCol >= col) {
            return false;
        }
        // balanceCount have to be between 0 and max
        if (balanceCount < 0 || balanceCount > max) {
            return false;
        }
        // if already visited
        if (visited[startRow][startCol][balanceCount] != null) {
            return visited[startRow][startCol][balanceCount];
        }
        
        // if we reach the end of the cell, just check whats our balance there
        if (startRow == row - 1 && startCol == col - 1) {
            if (grid[startRow][startCol] == '(') {
                balanceCount++;
            }
            else {
                balanceCount--;
            }
            return balanceCount == 0;
        }
        // do dfs accordingly for open and closed braces
        if (grid[startRow][startCol] == '(') {
            return visited[startRow][startCol][balanceCount] = dfs(grid, startRow + 1, startCol, balanceCount + 1, visited, row, col, max) || dfs(grid, startRow, startCol + 1, balanceCount + 1, visited, row, col, max);
        }
        return visited[startRow][startCol][balanceCount] = dfs(grid, startRow + 1, startCol, balanceCount - 1, visited, row, col, max) || dfs(grid, startRow, startCol + 1, balanceCount - 1, visited, row, col, max);
    }
}
