// this is my code and failing the one stage
// class Solution {
//     private final int mod = (int)1e9 + 7;
//     public int countPaths(int n, int[][] roads) {
//         if (roads == null || n == 0)
//             return 0;
//         List<List<Pair>> graph = buildGraph(n, roads);
//         // djiksrra
//         long [] dp = new long [n];
//         djikstra(dp, graph, 0, n);
//         return (int)(dp[n - 1] % mod);
//     }
    
//     public void djikstra(long[] dp, List<List<Pair>> graph, int source, int n) {
//         long [] distance = new long [n];
//         Arrays.fill(distance, Long.MAX_VALUE);
//         distance[0] = 0;
//         dp[0] = 1;
//         PriorityQueue<Pair> minHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.time, pair2.time));
//         minHeap.offer(new Pair(0, 0)); // node, time
//         while (!minHeap.isEmpty()) {
//             Pair currentPair = minHeap.poll();
//             int time = (int)currentPair.time;
//             int src = (int)currentPair.ending;
//             if (time > distance[src])
//                 continue;
//             List<Pair> children = graph.get(src);
//             for (Pair child : children) {
//                 int nextTime = (int)child.time;
//                 int nextSrc = (int)child.ending;
//                 if (distance[nextSrc] > time + nextTime) {
//                     distance[nextSrc] = time + nextTime;
//                     dp[nextSrc] = dp[src];
//                     minHeap.offer(new Pair(nextSrc, (int)distance[nextSrc]));
//                 }
//                 else if (distance[nextSrc] == time + nextTime) {
//                     dp[nextSrc] = (dp[src] + dp[nextSrc]);
//                     dp[nextSrc] %= mod;
//                 }
//             }
//         }
//     }
    
//     public List<List<Pair>> buildGraph(int n, int [][] roads) {
//         List<List<Pair>> graph = new ArrayList<>();
//         for (int i=0; i<n; i++) {
//             graph.add(new ArrayList<>());
//         }
//         for (int [] road : roads) {
//             int u = road[0];
//             int v = road[1];
//             int time = road[2];
//             graph.get(u).add(new Pair(v, time));
//             graph.get(v).add(new Pair(u, time));
//         }
//         return graph;
//     }
    
// }

// class Pair {
//     int ending;
//     int time;
//     public Pair(int ending, int time) {
//         this.ending = ending;
//         this.time = time;
//     }
// }



// accepted and taken from discuss for reference
class Solution {
int[] dist;
long[] dp;

public void findDis(Map<Integer, List<int[]>> graph){

 PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> (a[1]- b[1]));
 pq.add(new int[]{0, 0});
 dist[0]=0;
 dp[0]=1;
 while(!pq.isEmpty()){
     int[] top=pq.poll();
     int u=top[0], d=top[1];
     for(int[] v: graph.get(u)){
         if(dist[v[0]] > d + v[1]){
             dist[v[0]] = d+v[1];
             dp[v[0]]=dp[u];
             pq.offer(new int[]{v[0], dist[v[0]]});
         }else{
             if(dist[v[0]] == d+v[1]){
                 dp[v[0]]+=dp[u];
                 dp[v[0]]%= 1_000_000_007;
             }
         }
     }
 }
}

public int countPaths(int n, int[][] roads) {
dist=new int[n];
dp=new long[n];
Map<Integer, List<int[]>> graph=new HashMap();
Arrays.fill(dist, Integer.MAX_VALUE);
for(int i=0;i<n;i++){
graph.put(i, new ArrayList());

 }
 for(int[] e: roads){
     graph.get(e[0]).add(new int[]{e[1], e[2]});
     graph.get(e[1]).add(new int[]{e[0], e[2]});
 }
 findDis(graph);
 
 return (int)dp[n-1]%1_000_000_007;
}
}