class Solution {
    public int swimInWater(int[][] grid) {
        
        //  1. dfs
        int time = 0;
        int length = grid.length;
        Set<Integer> set = new HashSet<>();
        while (!set.contains(length * length - 1)) {
            set.clear();
            dfs(grid, 0, 0, time, set);
            time += 1;
        }
        return time - 1;
    }
    
    public void dfs(int [][] grid, int i, int j, int time, Set<Integer> set) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] > time || set.contains(i * grid.length + j))
            return;
        set.add(i * grid.length + j);
        dfs(grid, i+1, j, time, set);
        dfs(grid, i-1, j, time, set);
        dfs(grid, i, j+1, time, set);
        dfs(grid, i, j-1, time, set);
        
        
        // 2. union find
        int time = 0;
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);
        while (!uf.isConnected(0, n*n - 1)) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (grid[i][j] > time)
                        continue;
                    if (i < n - 1 && grid[i+1][j] <= time)
                        uf.union(i * n + j, i * n + j + n);
                    if (j < n - 1 && grid[i][j+1] <= time)
                        uf.union(i * n + j, i * n + j + 1);
                }
            }
            time += 1;
        }
        return time -1;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Cannot be less than or equal to 0");
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i=0; i<n; i++)
            parent[i] = i;
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ])
                rank[rootP] += 1;
        }
        component -= 1;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    
        
        // 3 .djikstras algorithm
        int n = grid.length;
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> grid[a/n][a%n] - grid[b/n][b%n]);
        pq.add(0);
        boolean [][] visited = new boolean [n][n];
        int [][] directions = new int [][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!pq.isEmpty()) {
            int pos = pq.remove();
            int row = pos / n;
            int col = pos % n;
            time = Math.max(time, grid[row][col]);
            if (row == n - 1 && col == n - 1)
                return time;
            for (int [] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || visited[newRow][newCol])
                    continue;
                visited[newRow][newCol] = true;
                pq.add(newRow * n + newCol);
            }
        }
        return -1;
    }
}
