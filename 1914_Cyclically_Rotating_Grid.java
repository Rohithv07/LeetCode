class Solution {
int m,n;

public int[][] rotateGrid(int[][] grid, int k) {
   
    m = grid.length;
    n = grid[0].length;
    int ll = Math.min(m, n) / 2; // number of cycles
    
    for(int l = 0; l < ll; ++l) {
        List<Integer> list = new ArrayList();
        
        // top row
        for(int i = l; i < n - l - 1; ++i)
            list.add(grid[l][i]);
        
        // right
        for(int i = l; i < m - l - 1; ++i)
            list.add(grid[i][n - l - 1]);
    
        // bottom row
        for(int i = n - l - 1; i > l; --i)
            list.add(grid[m - l - 1][i]);
        
        // left
        for(int i = m - l - 1; i > l; --i)
            list.add(grid[i][l]);
       
        // rotate, instead of mutating the array add elements upto k again and 
        // while assigning to orignal grid assign from index start
        int kk = k % list.size();
        for(int i = 0; i < kk; ++i)
            list.add(list.get(i));
        
        // assign it back to the grid -> please not the start here 
        assign(grid, l, list, kk);
    }
    
    return grid;
}
    
void assign(int[][] grid, int l, List<Integer> list, int start) {
    // top row
    for(int i = l; i < n - l - 1; ++i)
        grid[l][i] = list.get(start++);

    // right
    for(int i = l; i < m - l - 1; ++i)
       grid[i][n - l - 1] = list.get(start++);

    // bottom row
    for(int i = n - l - 1; i > l; --i)
        grid[m - l - 1][i] = list.get(start++);

    // left
    for(int i = m - l - 1; i > l; --i)
        grid[i][l] = list.get(start++);
}
}
