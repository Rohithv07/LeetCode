class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = buildGraph(connections);
        Set<List<Integer>> possibleConnectionSet = new HashSet<>(connections);
        int [] rank = new int [n];
        Arrays.fill(rank, -2);
        dfsHelper(graph, rank, 0, 0, possibleConnectionSet); // returns the min rank
        return new ArrayList<>(possibleConnectionSet);
    }
    
    public int dfsHelper(Map<Integer, List<Integer>> graph, int [] rank, int node, int depth, Set<List<Integer>> possibleConnectionSet) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int currentMinDepth = depth;
        System.out.println(graph.get(node));
        for (Integer currentNode : graph.get(node)) {
            //for (Integer currentNode: child) {
                if (rank[currentNode] >= depth - 1)  // parent
                    continue;
                int minDepth = dfsHelper(graph, rank, currentNode, depth + 1, possibleConnectionSet);
                currentMinDepth = Math.min(currentMinDepth, minDepth);
                if (minDepth <= depth) {
                    possibleConnectionSet.remove(Arrays.asList(node, currentNode));
                    possibleConnectionSet.remove(Arrays.asList(currentNode, node));
                }
            //}
        }
        return currentMinDepth;
    }
    
    public Map<Integer, List<Integer>> buildGraph(List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> conn : connections) {
            graph.computeIfAbsent(conn.get(0), x -> new ArrayList<>()).add(conn.get(1));
            graph.computeIfAbsent(conn.get(1), x -> new ArrayList<>()).add(conn.get(0));
        }
        return graph;
    }
}
