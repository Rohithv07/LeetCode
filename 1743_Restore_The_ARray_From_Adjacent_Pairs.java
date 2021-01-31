class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int row = adjacentPairs.length;
        int col = adjacentPairs[0].length;
        int [] answer = new int [row + 1];
        Map<Integer, Set<Integer>> graph = buildGraph(adjacentPairs);
        // now the graph is built
        // we need to get the first number with only 1 neighbour as it will be our 1st element
        int start = 0;
        for (int node : graph.keySet()) {
            // get the first number that have a set size of 1
            if (graph.get(node).size() == 1) {
                start = node;
                break;
            }
        }
        // now we get the start point
        // maintain a Set to check for the visit or not
        Set<Integer> visited = new HashSet<>();
        // here we can try the bfs and get the neighbour if present and add it into the queue
        Queue<Integer> queue = new LinkedList<>();
        // add the start
        queue.offer(start);
        visited.add(start);
        int index = 0;
        
        // BFS PART : 
        while (!queue.isEmpty()) {
            int current = queue.poll();
            Set<Integer> neighbour = graph.get(current);
            answer[index++] = current;
            // add each neighbour of current element to the queue and do the bfs
            for (int child : neighbour) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.offer(child);
                }
            }
        }
        /* For BFS after completing here, just return the answer and thats it, the below code is for dfs functioning*/
        
        // this is the dfs code, either of these two codes are properly working
        // we can also try the dfs code
        // here we might need an array list and values are added to it and then it can be converted back to our required array
        List<Integer> temp = new ArrayList<>();
        dfs(graph, visited, temp, start);
        // this loop is needed for dfs to convert list to arraay
        for (int i=0; i<temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
    
    // this is the dfs part
    public void dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, List<Integer> temp, int start) {
        visited.add(start);
        temp.add(start);
        Set<Integer> neighbours = graph.get(start);
        for (Integer child : neighbours) {
            if (!visited.contains(child)) {
                visited.add(child);
                dfs(graph, visited, temp, child);
            }
        }
    }
    public Map<Integer, Set<Integer>> buildGraph(int [][] grid) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // we can build a undirected graph as its given in question "every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order."
        for (int [] g : grid) {
            map.computeIfAbsent(g[0], x -> new HashSet<>()).add(g[1]);
            map.computeIfAbsent(g[1], x -> new HashSet<>()).add(g[0]);
        }
        return map;
    }
}
