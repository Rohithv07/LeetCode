// 1. Firt we build an undirected graph.
// 2. Then we created a boolean array to keep track of the visited node and set the root as true.
// 3. Now we do the dfs startign from 0.
// 4. The base condition is if the node is null, then we return 0.
// 5. Then we traverse throught the children and we take each child and check whether visited, if not then we make it visited
        // and increment do count += dfs()
// 6. If our count > 0 or the current node has apple and node != root or 0, then we have to increment count by 2.
// 7. Now finallly return the count and dfs function returns this count.

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++)
            adj.add(i, new LinkedList<>());
        for (int []e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean [] visited = new boolean[n];
        visited[0] = true;
        return dfs(adj, hasApple, 0, visited);
    }
    public int dfs(List<List<Integer>> adj, List<Boolean> hasApple, int v, boolean [] visited) {
        if (adj.get(v) == null)
            return 0;
        int count = 0;
        List<Integer> children = adj.get(v);
        for (int child: children) {
            if (!visited[child]) {
                visited[child] = true;
                count += dfs(adj, hasApple, child, visited);
            }
        }
        if ((count>0 || hasApple.get(v)) && v != 0)
            count += 2;
        return count;
    }
}
