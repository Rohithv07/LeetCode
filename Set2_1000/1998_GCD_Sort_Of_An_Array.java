// good ref with pic : https://leetcode.com/problems/gcd-sort-of-an-array/discuss/1445437/JAVA-Sieve-Union-Find-With-detailed-explanation(with-proof)

class Solution {
    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();
        int max = -1;
        for (int number : nums) {
            visited.add(number);
            max = Math.max(max, number);
        }
        int [] sortedArray = new int [n];
        for (int i=0; i<n; i++) {
            sortedArray[i] = nums[i];
        }
        Arrays.sort(sortedArray);
        UnionFind uf = new UnionFind(max + 1);
        boolean [] prime = new boolean [max + 1];
        for (int i=2; i*2<=max; i++) {
            if (!prime[i]) {
                for (int j=2; i*j<=max; j++) {
                    if (visited.contains(i * j)) {
                        uf.union(i, i*j);
                    }
                    prime[i * j] = true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (!uf.isConnected(nums[i], sortedArray[i]))
                return false;
        }
        return true;
    }
}

class UnionFind {
    int component;
    int size;
    int [] parent;
    int [] rank;
    UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n can't be 0 or negative");
        }
        component = n;
        size = n;
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
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else  {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP] += 1;
            }
        }
        component--;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}