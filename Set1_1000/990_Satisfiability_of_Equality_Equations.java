class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0), s.charAt(3));
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (uf.find(s.charAt(0) - 'a') == uf.find(s.charAt(3) - 'a'))
                    return false;
            }
        }
        return true;
    }
}


class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Error");
        }
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(char p, char q) {
        int rootP = find(p - 'a');
        int rootQ = find(q - 'a');
        if (rootQ == rootP)
            return;
        if (rank[rootQ] > rank[rootP]) {
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
}
