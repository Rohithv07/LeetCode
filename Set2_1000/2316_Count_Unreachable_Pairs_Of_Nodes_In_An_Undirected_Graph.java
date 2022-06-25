class Solution {
    public long countPairs(int n, int[][] edges) {
        long unreachable = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean [] visited = new boolean [n];
        long result = 0;
        int [] count = new int []{0};
        int previous = 0;        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i, count);
                long a = n - count[0];
                long b = count[0] - previous;
                previous = count[0];
                result += (a * b);
            }
        }
        return result;
    }
    
    private void dfs(List<List<Integer>> graph, boolean [] visited, int node, int [] count) {
        visited[node] = true;
        count[0]++;
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(graph, visited, child, count);
            }
        }
    }
}


