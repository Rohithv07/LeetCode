/*
-> Extract separate graphs, mapping the characters and there vertices.
-> Sort the characters in ascending order within each graph.
-> Put the characters in correct position after populating the output, by taking the characters from the graph.
*/

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        char [] array = s.toCharArray();
        UnionFind uf = new UnionFind(length);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> graph = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int root = uf.find(i);
            graph.computeIfAbsent(root, x -> new PriorityQueue<>()).offer(array[i]);
        }
        // the advantage of priorityqueue is, we don't want to again sort it
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int root = uf.find(i);
            result.append(graph.get(root).poll());
        }
        return result.toString();
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be less than or equal to zero");
        }
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
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
                rank[rootP] += 1;
            }
        }
        component--;
    }
}