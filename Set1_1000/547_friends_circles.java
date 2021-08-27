// here we can do dfs and count the number of friends accoridng to the condition
// first we go throught the roq ansd check whether if it is not visited, if not visited we do the dfs column wise
// inside the dfs funxction, if we already visited a particulkar item just return
// else just mark the current as visited for do the traverse on the column
// if its not visited and the corresponding cell = 1, do the dfs
class Solution {
    public int findCircleNum(int[][] M) {
        int friendCount = 0;
        // a boolean array for visited
        int row = M.length;
        boolean [] visited = new boolean[row];
        for (int i=0; i<row; i++) {
            if (!visited[i]) {
                // do the dfs and increase the count
                dfs(M, visited, i);
                friendCount += 1;
            }
        }
        return friendCount;
    }
    public void dfs(int [][] M, boolean [] visited, int current) {
        if (visited[current])
            return;
        visited[current] = true;
        for (int i=0; i<M[current].length; i++) {
            if (!visited[i] && M[current][i] == 1)
                // continue the dfs
                dfs(M, visited, i);
        }
    }
}



// union find

class Solution {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i=0; i<M.length - 1; i++) {
            for (int j=i+1; j<M.length; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.getComponent();
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Error");
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
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ])
                rank[rootP] += 1;
        }
        component -= 1;
    }
    
    public int getComponent() {
        return component;
    }
}
