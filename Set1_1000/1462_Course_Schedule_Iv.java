// Floyd Warshall

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        boolean [][] canConnect = new boolean[n][n];
        for (int [] p: prerequisites)
            canConnect[p[0]][p[1]] = true;
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    canConnect[i][j] = canConnect[i][j] || canConnect[i][k] && canConnect[k][j];
                }
            }
        }
        for (int [] q: queries) {
            result.add(canConnect[q[0]][q[1]]);
        }
        return result;
    }
}

// DFS

class Solution {
    boolean [][] visited;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        visited = new boolean[n][n];
        for (int i=0; i<n; i++)
            adj.add(new LinkedList<>());
        for (int [] p: prerequisites) {
            adj.get(p[0]).add(p[1]);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i=0; i<n; i++)
            dfs(adj, visited, i, i);
        for (int [] q: queries) {
            result.add(visited[q[0]][q[1]]);
        }
        return result;
    }
    public void dfs(List<List<Integer>> adj, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        List<Integer> children = adj.get(j);
        for (Integer child: children) {
            if (!visited[i][child])
                dfs(adj, visited, i, child);
        }
    }
}
