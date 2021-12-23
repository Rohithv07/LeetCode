
class Solution {
    public boolean isBipartite(int[][] graph) {
        int row = graph.length;
        UnionFind uf = new UnionFind(row);
        for (int i=0; i<row; i++) {
            for (int j=0; j<graph[i].length; j++) {
                if (uf.find(i) == uf.find(graph[i][j]))
                    return false;
                uf.union(graph[i][0], graph[i][j]);
            }
        }
        return true;
    }
}

public class UnionFind {
    int size;
    int numberOfComponents;
    int [] parent;
    int [] rank;
   public UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Size <= 0 is not allowed");
        size = n;
        numberOfComponents = n;
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
        numberOfComponents -= 1;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int size() {
        return size;
    }
    
    public int components() {
        return numberOfComponents;
    }
}


/*
0: Haven't been colored yet.
1: Blue.
-1: Red.
*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];			
				
        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }       
        colors[node] = color;       
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}


// using dfs and bfs helper functions combined


class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int length = graph.length;
        int [] color = new int [length];
        for (int i=0; i<length; i++) {
            // if (color[i] == 0 && !dfs(graph, color, 1, i)) {
            //     return false;
            // }
            if (color[i] == 0 && !bfs(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean bfs(int [][] graph, int [] color, int node, int coloring) {
        color[node] = coloring;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentNode = queue.poll();
                int [] children = graph[currentNode];
                for (Integer child : children) {
                    if (color[child] == 0) {
                        if (color[currentNode] == coloring) {
                            color[child] = -coloring;
                        }
                        else if (color[currentNode] == -coloring) {
                            color[child] = coloring;
                        }
                        queue.offer(child);
                    }
                    else {
                        if (color[child] == color[currentNode]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public boolean dfs(int [][] graph, int [] color, int coloring, int node) {
        if (color[node] != 0) {
            return color[node] == coloring;
        }
        color[node] = coloring;
        int [] children = graph[node];
        for (Integer child : children) {
            if (!dfs(graph, color, -coloring, child)) {
                return false;
            }
        }
        return true;
    }
}



