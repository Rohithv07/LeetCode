
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // this is Djikstra : V + ElogE
        List<int[]> [] adj = buildGraph(times, N);
        int [] distance = new int [N];
        int maxDistance = 0;
        Arrays.fill(distance, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int [] {K-1, 0});
        distance[K-1] = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.remove()[0];
            for (int [] pair : adj[currentNode]) {
                int currentTarget = pair[0];
                int currentTime = pair[1];
                int currentDistance = distance[currentNode] + currentTime;
                if (distance[currentTarget] == -1 || distance[currentTarget] > currentDistance) {
                    distance[currentTarget] = currentDistance;
                    queue.add(new int [] {currentTarget, distance[currentTarget]});
                }
            }
        }
        for (int i=0; i<N; i++) {
            if (distance[i] == -1)
                return -1;
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        return maxDistance;
    }
    
    public List<int[]>[] buildGraph(int [][] times, int N) {
        List<int[]>[] adj = new ArrayList[N];
        for (int i=0; i<N; i++)
            adj[i] = new ArrayList<>();
        for (int [] t : times) {
            adj[t[0] - 1].add(new int [] {t[1] - 1, t[2]});
        }
        return adj;
    } 
}



class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // bellman ford - O(VE)
        int [] dist = new int [N + 1];
        int maximum = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        for (int i=1; i<N; i++) {
            for (int [] edges : times) {
                int current = edges[0];
                int next = edges[1];
                int weight = edges[2];
                int distance = dist[current] + weight;
                if (dist[current] != Integer.MAX_VALUE && dist[next] > distance)
                    dist[next] = distance;
            }
        }
        for (int i=1; i<=N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            maximum = Math.max(maximum, dist[i]);
        }
        return maximum;
    }
}
