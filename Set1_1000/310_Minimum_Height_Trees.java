class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i=0; i<n; i++)
            adjacent.add(new LinkedList<>());
        int [] degree = new int [n];
        for (int [] edge: edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
            degree[edge[0]]+=1;
            degree[edge[1]]+=1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<degree.length; i++) {
            if (degree[i] == 1)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            List<Integer> temporary = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int node = queue.poll();
                temporary.add(node);
                degree[node] = 1;
                List<Integer> children = adjacent.get(node);
                for (int j=0; j<children.size(); j++) {
                    int v = children.get(j);
                    degree[v]-=1;
                    if (degree[v] == 1)
                        queue.add(v);
                }
            }
            result = temporary;
        }
        return result;
    }
}
