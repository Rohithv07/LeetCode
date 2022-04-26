class Solution {
    public int minCostConnectPoints(int[][] points) {
        // prims
        int n = points.length;
        // make use of a priority queue based on the cost we are going to calculate
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int [] {0, 0, 0});
        // a boolean array to mark visited
        boolean [] visited = new boolean [n];
        int cost = 0;
        int edges = 0;
        // we make use of loop that run until the priority queue empty || edges = n-1 
        while (!pq.isEmpty() || edges < n - 1) {
            int [] current = pq.remove();
            if (visited[current[1]])
                continue;
            visited[current[1]] = true;
            cost += current[2];
            edges += 1;
            for (int j = 0; j< n; j++) {
                if (!visited[j])
                    pq.add(new int [] {current[1], j, Math.abs(points[current[1]][0] - points[j][0]) + Math.abs(points[current[1]][1] - points[j][1])});
            }
        }
        return cost;
    }
}


// Kruskal algorithm

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Node> graph = buildGraph(points);
        UnionFind uf = new UnionFind(n);
        Collections.sort(graph, (g1, g2) -> Integer.compare(g1.weight, g2.weight));
        int cost = 0;
        int edgesUsed = 0; // we only need to look for n - 1 edges.
        for (Node node : graph) {
            int source = node.source;
            int destination = node.destination;
            int weight = node.weight;
            if (uf.isConnected(source, destination)) {
                continue;
            }
            uf.union(source, destination);
            cost += weight;
            edgesUsed++;
            if (edgesUsed >= n - 1) {
                break;
            } // this is an optimization step
        }
        return cost;
    }
    
    public List<Node> buildGraph(int [][] points) {
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int source = i;
                int destination = j;
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.add(new Node(source, destination, weight));
            }
        }
        return graph;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Cannot be zero or negative");
        }
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
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
        if (rank[rootQ] > rank[rootP]) {
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
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}

class Node {
    int weight;
    int source;
    int destination;
    public Node(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}