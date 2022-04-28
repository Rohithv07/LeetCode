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


// use maxheap to track the max probability

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double [] distance = new double [n];
        distance[start] = 1.0;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            double weight = succProb[i];
            graph.get(s).add(new Pair(d, weight));
            graph.get(d).add(new Pair(s, weight));
        }
        
        // here we need max probability, so we use maxHeap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((t1, t2) -> Double.compare(t2.weight, t1.weight));
        maxHeap.offer(new Pair(start, distance[start]));
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            int s = current.start;
            double weight = current.weight;
            if (s == end) {
                return weight;
            }
            List<Pair> children = graph.get(s);
            for (Pair child : children) {
                int childNode = child.start;
                double childWeight =  child.weight;
                if (distance[s] * childWeight > distance[childNode]) {
                    distance[childNode] = distance[s] * childWeight;
                    maxHeap.offer(new Pair(childNode, distance[childNode]));
                }
            }
        }
        return 0.0;
    }
}

class Pair {
    int start;
    double weight;
    
    public Pair(int start, double weight) {
        this.start = start;
        this.weight = weight;
    }
}