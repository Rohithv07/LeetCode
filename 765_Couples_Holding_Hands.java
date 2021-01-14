// The min number of swaps = N - number of connected components where N = number of couples;
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i=0; i<n; i++) {
            int lover1 = row[2 * i];
            int lover2 = row[2 * i + 1];
            unionFind.union(lover1/2, lover2/2);
        }
        return n - unionFind.component;
    }
}


class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("can't be equal to or less than 0");
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
        if (rank[rootP] < rank[rootQ])
            parent[rootP] = rootQ;
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ])
                rank[rootP] += 1;
        }
        component -= 1;
    }
}
