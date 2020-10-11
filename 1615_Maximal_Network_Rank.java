class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0)
            return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int [] rank = new int [n];
        for (int [] road: roads) {
            graph.computeIfAbsent(road[0], x->new HashSet<>()).add(road[1]);
            graph.computeIfAbsent(road[1], x->new HashSet<>()).add(road[0]);
            for (int r: road) {
                rank[r] += 1;
            }
        }
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int r = graph.getOrDefault(i, Collections.emptySet()).contains(j) ? -1 : 0;
                r += rank[i] + rank[j];
                max = Math.max(r, max);
            }
        }
        return max;
    }
}

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean [][] visited = new boolean[n][n];
        int [] rank = new int [n];
        for (int [] road: roads) {
            visited[road[0]][road[1]] = true;
            visited[road[1]][road[0]] = true;
            rank[road[0]] += 1;
            rank[road[1]] += 1;
        }
        int max = 0; 
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int count = rank[i] + rank[j];
                if (visited[i][j])
                    count -= 1;
                max = Math.max(count, max);
            }
        }
        return max;
    }
}


