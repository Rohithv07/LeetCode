class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // construct the map
        Map<Integer, List<int[]>> graph = generateGraph(edges);
        // generate a probability array to track down the probability
        double [] probability = new double[n];
        // make the prob of start as 1 and all others 0
        probability[start] = 1d;
        // use a priorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -probability[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int current = pq.poll();
            // if reached the end position
            if (current == end)
                return probability[end];
            for (int [] child : graph.getOrDefault(current, Collections.emptyList())) {
                int neighbour = child[0];
                int neighbourIndex = child[1];
                // check if the product of currentProb and value at the succprob of neighbor index > probability of neighbour
                // if yes, update the probability of neighbour
                // add the neighbour to the pq
                double currentProb = probability[current] * succProb[neighbourIndex];
                if (currentProb > probability[neighbour]) {
                    probability[neighbour] = currentProb;
                    pq.offer(neighbour);
                }
            }
        }
        return 0d;
    }
    
    public Map<Integer, List<int[]>> generateGraph(int [][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            // we need an undirected graph -> we add neighbours, index
            graph.computeIfAbsent(a, x -> new ArrayList<>()).add(new int []{b, i});
            graph.computeIfAbsent(b, x -> new ArrayList<>()).add(new int []{a, i});
        }
        return graph;
    }
}
