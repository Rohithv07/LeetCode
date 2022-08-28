/*

1. Build the graph for the given 2 row and col 2d array
2. Find the in degree for the 2 2d array
3. Keep a kind of map for the row and col
4. Do the topological sorting individually for both the 2 generated graph
5. If we see any of the node which is not visited, it means there is a cycle and we cannot make a topological sort
6. Else store the result



*/


class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> graphRow = buildGraph(rowConditions, k);
        List<List<Integer>> graphCol = buildGraph(colConditions, k);
        int [] rowIndegree = findIndegree(rowConditions, k);
        int [] colIndegree = findIndegree(colConditions, k);
        int [][] topoOrderRowCol = new int [k][2];
        int [][] result = new int [k][k];
        boolean [] rowVisited = new boolean [k];
        boolean [] colVisited = new boolean [k];
        // a boolean is introduced at the end to handle the rowCondition and colCondition separately in a single function
        bfsTopo(graphRow, topoOrderRowCol, rowVisited, rowIndegree, k, true, 0);
        bfsTopo(graphCol, topoOrderRowCol, colVisited, colIndegree, k, false, 0);
        for (int i = 0; i < k; i++) {
            // arises when cycle
            if (!rowVisited[i] || !colVisited[i]) {
                return new int [][]{};
            }
            result[topoOrderRowCol[i][0]][topoOrderRowCol[i][1]] = i + 1;
        }
        return result;
    }
    
    private void bfsTopo(List<List<Integer>> graph, int [][] topo, boolean [] visited, int [] indegree, int k, boolean isRow, int rowColNumber) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (isRow) {
                    topo[node][0] = rowColNumber++;
                }
                else {
                    topo[node][1] = rowColNumber++;
                }
                List<Integer> children = graph.get(node);
                for (Integer child : children) {
                    if (!visited[child]) {
                        indegree[child]--;
                        if (indegree[child] == 0) {
                            queue.offer(child);
                            visited[child] = true;
                        }
                    }
                }
            }
        }
    }
    
    private List<List<Integer>> buildGraph(int [][] g, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] node : g) {
            graph.get(node[0] - 1).add(node[1] - 1);
        }
        return graph;
    }
    
    private int [] findIndegree(int [][] mat, int k) {
        int [] degree = new int [k];
        for (int [] m : mat) {
            degree[m[1] - 1]++;
        }
        return degree;
    }
}