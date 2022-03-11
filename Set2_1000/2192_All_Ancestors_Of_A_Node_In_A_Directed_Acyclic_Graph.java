class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Set<Integer> [] ancestors = new TreeSet[n];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] parent = new ArrayList[n];
        for (int i = 0; i < n; ++ i) {
            parent[i] = new ArrayList<>();
        }
        
        for (int[] edge: edges) {
            parent[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (ancestors[i] == null) {
                dfs(i, parent, ancestors);
            }
            result.add(new ArrayList<>(ancestors[i]));
        }
        
        return result;
    }
    
    public void dfs(int node, List<Integer>[] parent, Set<Integer>[] ancestors) {
        List<Integer> children = parent[node];
        Set<Integer> set = new TreeSet<>();
        for (Integer child : children) {
            set.add(child);
            if (ancestors[child] == null) {
                dfs(child, parent, ancestors);
            }
            set.addAll(ancestors[child]);
        }
        ancestors[node] = set;
    }
    
    
    public List<Integer>[] buildReverse(int n, int [][]edges) {
        List<Integer> [] parent = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            parent[i] = new ArrayList<>();
        }
        for (int [] edge : edges) {
            parent[edge[1]].add(edge[0]);
        }
        return parent;
    }
}