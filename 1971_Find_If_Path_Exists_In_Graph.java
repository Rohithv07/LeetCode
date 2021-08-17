class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (edges == null || edges.length == 0 || start < 0 || end < 0)
            return true;
        List<List<Integer>> graph = buildGraph(edges, n);
        return bfs(graph, start, end, n);
    }
    
    public boolean bfs(List<List<Integer>> graph, int start, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean [n];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentNode = queue.poll();
                if (currentNode == end)
                    return true;
                List<Integer> children = graph.get(currentNode);
                if (children == null)
                    continue;
                for (Integer child : children) {
                    if (child == end)
                        return true;
                    if (!visited[child]) {
                        queue.offer(child);
                        visited[child] = true;
                    }
                }
            }
        }
        return false;
    }
    
    public List<List<Integer>> buildGraph(int [][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}