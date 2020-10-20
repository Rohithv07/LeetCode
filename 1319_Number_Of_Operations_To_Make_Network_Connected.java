// here I implemented a dfs function which goes through all the computer and connections and find the computer that are not yet connected.
// if we have a connection length >= n-1 then only we can make fully connected so this is the base condition to check early.
// then we build undirected graph and make use of boolean array to track visited or not visited
// then through all the computers as node we call our dfsHelperFunction and add it with the component variable we need to return.
// we return component - 1 as we need only that much to connect all as we need to return the minimum.

// inside the dfsHelper function we check whtehr the computer is already visited or not, if visited return 0;
// otherwise we mark it as visited and go through its children and do the dfs and thus we get a increment in the number of components.

// Here we go through each and every computer and their connections 
// time complexity = O(computer + connectionLength)


class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1)
            return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++)
            adj.add(new LinkedList<>());
        for (int [] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }
        boolean [] visited = new boolean [n];
        int components = 0;
        int result = 0;
        for (int i=0; i<n; i++)
            components += dfsHelper(adj, visited, i);
        return components - 1;
    }
    public int dfsHelper(List<List<Integer>>adj, boolean [] visited, int computer) {
        if (visited[computer])
            return 0;
        visited[computer] = true;
        List<Integer> children = adj.get(computer);
        for (Integer child : children) {
            if (!visited[child])
                dfsHelper(adj, visited, child);
        }
        return 1;
    }
}
