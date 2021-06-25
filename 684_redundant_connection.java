class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        UnionFind uf = new UnionFind(length);
        int component = uf.getComponent();
        for (int [] edge: edges) {
            int p1 = uf.find(edge[0] - 1);
            int p2 = uf.find(edge[1] - 1);
            if (p1 == p2) {
                return new int [] {edge[0], edge[1]};
            }
            else {
                uf.union(edge[0] - 1, edge[1] - 1);
            }
        }
        return new int [] {};
    }
}

class UnionFind {
    int component;
    int size;
    int [] parent;
    int [] rank;
    UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n can't be negative");
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP] += 1;
            }
        }
        component -= 1;
    }
    
    int getComponent() {
        return component;
    }
}



class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 0)
            return null;
        int [] parent = new int[edges.length+1];
        for (int i=0; i<edges.length+1; i++)
            parent[i] = -1;
        for (int []edge:edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y)
                return new int[]{edge[0], edge[1]};
            else
                union(parent, x, y);
        }
        return null;
    }
    public int find(int [] parent, int v) {
        if (parent[v] == -1)
            return v;
        return find(parent, parent[v]);
    }
    public void union(int [] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }   
}

