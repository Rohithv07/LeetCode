class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        // reverse the graph
        // find the shortest distance from the current destination to all the cities
        // List<List<Pair>> reverseGraph = buildReverseGraph(edges, n);
        // List<List<Pair>> graph = buildNormalGraph(edges, n);
        List<List<Pair>> reverseGraph = new ArrayList<>();
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            reverseGraph.get(edge[1]).add(new Pair(edge[0], edge[2]));
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        // do dijkstra on src1, src2 on normal graph and for the dest, on the reverse graph
        long [] distanceFromSrc1 = new long [n];
        long [] distanceFromSrc2 = new long [n];
        long [] distanceFromDestination = new long [n];
        Arrays.fill(distanceFromSrc1, Long.MAX_VALUE);
        Arrays.fill(distanceFromSrc2, Long.MAX_VALUE);
        Arrays.fill(distanceFromDestination, Long.MAX_VALUE);
        distanceFromSrc1[src1] = 0l;
        distanceFromSrc2[src2] = 0l;
        distanceFromDestination[dest] = 0l;
        // do djiktra from the destination to all the cities and fill the distance array
        dijkstra(graph, distanceFromSrc1, src1);
        dijkstra(graph, distanceFromSrc2, src2);
        dijkstra(reverseGraph, distanceFromDestination, dest);
        // now we have all the distance array
        // avoiding the unreachable condition, take the min of dsrc1 + dsrc2 + ddest1
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (distanceFromSrc1[i] == Long.MAX_VALUE || distanceFromSrc2[i] == Long.MAX_VALUE || distanceFromDestination[i] == Long.MAX_VALUE) {
                continue;
            }
            result = Math.min(result, distanceFromSrc1[i] + distanceFromSrc2[i] + distanceFromDestination[i]);
        }
        return result == Long.MAX_VALUE ? -1 : result;
    }
    
    public void dijkstra(List<List<Pair>> graph, long [] distance, int dest) {
        // we need minheap for dijkstra
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((pair1, pair2) -> Long.compare(pair1.weight, pair2.weight));
        minHeap.offer(new Pair(dest, 0));
        while (!minHeap.isEmpty()) {
            Pair currentPair = minHeap.poll();
            int node = currentPair.node;
            long weight = currentPair.weight;
            if (weight > distance[node]) {
                continue;
            } // this one line will get rid of TLE
            List<Pair> children = graph.get(node);
            for (Pair child : children) {
                if (distance[node] + child.weight < distance[child.node]) {
                    distance[child.node] = distance[node] + child.weight;
                    minHeap.offer(new Pair(child.node, distance[child.node]));
                }
            }
        }
    }
    
    public List<List<Pair>> buildReverseGraph(int [][] edges, int n) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        return graph;
    }
    
    public List<List<Pair>> buildNormalGraph(int [][] edges, int n) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        return graph;
    }
}

class Pair {
    int node;
    long weight;
    public Pair(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }
}