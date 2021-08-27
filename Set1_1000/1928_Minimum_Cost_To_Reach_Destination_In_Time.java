class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int length = passingFees.length;
        List<int[]>[] graph = buildGraph(edges, length);
        int [] minimumTime = new int [length];
        Arrays.fill(minimumTime, Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int [] {0, passingFees[0], 0});
        // source, passingfee for source, totaltime
        int time = 0;
        int score = 0;
        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            if (current[2] >= minimumTime[current[0]])
                continue;
            minimumTime[current[0]] = current[2];
            if (current[0] == length - 1)
                return current[1];
            for (int [] nextChild : graph[current[0]]) {
                time = current[2] + nextChild[1];
                score = current[1] + passingFees[nextChild[0]];
                if (time > maxTime)
                    continue;
                if (time > minimumTime[nextChild[0]])
                    continue;
                pq.add(new int [] {nextChild[0], score, time});
            }
        }
        return -1;
    }
    
    public List<int[]>[] buildGraph(int [][] edges, int length) {
        List<int[]> [] graph = new ArrayList[length];
        for (int i=0; i<length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int [] edge : edges) {
            graph[edge[0]].add(new int [] {edge[1], edge[2]});
            graph[edge[1]].add(new int [] {edge[0], edge[2]});
        }
        return graph;
    }
}