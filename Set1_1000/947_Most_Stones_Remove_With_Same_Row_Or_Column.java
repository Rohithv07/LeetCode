/*
Reference : 
"~" is the bitwise complement operator which means the negation of each bit of the input value, e.g., 00000110 -> 11111001. In this solution, the author just uses this operator to transform j to a new range so that j will not conflict with i.
*/
    
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        // build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int [] stone : stones) {
            map.computeIfAbsent(stone[0], x -> new ArrayList<>()).add(~stone[1]);
            map.computeIfAbsent(~stone[1], x -> new ArrayList<>()).add(stone[0]);
        }
        int component = 0;
        Set<Integer> visited = new HashSet<>();
        for (int [] stone : stones) {
            for (int i=0; i<2; i++) {
                int current = i == 0 ? stone[0] : ~stone[1];
                if (!visited.contains(current)) {
                    component += 1;
                    dfs(map, visited, current);
                }
            }
        }
        return n - component;
    }
    
    public void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int i) {
        if (visited.contains(i))
            return;
        visited.add(i);
        List<Integer>children = map.get(i);
        for (Integer child : children) {
            if (!visited.contains(child)) {
                dfs(map, visited, child);
            }
        } 
    }
}

// union find solution

class Solution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        
        int length = stones.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (stones[i][0] == stones[j][0] || stones[j][1] == stones[i][1]) {
                    unionFind.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (unionFind.find(i) == i) {
                count++;
            }
        }
        return length - unionFind.getComponent();
    }
}

class UnionFind {
    int size;
    int component;
    int [] rank;
    int [] parent;
    
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be less than or equal to 0");
        }
        size = n;
        component = n;
        rank = new int [n];
        parent = new int [n];
        for (int i = 0; i < n; i++) {
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
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        component--;
    }
    
    public int getComponent() {
        return component;
    }
}
