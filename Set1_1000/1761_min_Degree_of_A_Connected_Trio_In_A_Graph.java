class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int minimumDegree = Integer.MAX_VALUE;
        
        // arrange the array edges such that if e[0] > e[1], swap e[1] and e[0]
        for (int [] e : edges) {
            if (e[0] > e[1]) {
                int temp = e[0];
                e[0] = e[1];
                e[1] = temp;
            }
        }
        // now sort the edges. 2 conditions to check
        // if e1[0] == e2[0] then sort based on e1[1] and e2[1]
        // else do the sorting based on e1[0] and e2[0]
        Arrays.sort(edges, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        
        // build the graph and we dont want to consider duplicates, so use a set to track the neighbours
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int [] e : edges) {
            graph.computeIfAbsent(e[0], x -> new HashSet<>()).add(e[1]);
            graph.computeIfAbsent(e[1], x -> new HashSet<>()).add(e[0]);
        }
        
        // again go through the edges
        // e[0] = first e[1] = second now from i = second + 1 to n -> where third = i, then check
        // if graph have third
        // if the third have neighbours first in it.
        // if the third have neighbours second in it.
        // if it holds true, then compute each of the size eg : graph.get(first).size() + secondSize + thirdSize - 6
        // then greedily consider the value for degree
        
        for (int [] e : edges) {
            int first = e[0];
            int second = e[1];
            for (int i = second + 1; i<=n; i++) {
                int third = i;
                if (graph.containsKey(third) && graph.get(third).contains(first) && graph.get(third).contains(second)) {
                    int currentDegree = graph.get(first).size() + graph.get(second).size() + graph.get(third).size() - 6;
                    minimumDegree = Math.min(minimumDegree, currentDegree);
                }
            }
        }
        
        // for the last check if our minimumDegree is still Integer.MAX_Value return -1 else return minimumDegree
        return minimumDegree == Integer.MAX_VALUE ? -1 : minimumDegree;
    }
}
