class Solution {
    public int findCenter(int[][] edges) {
        // normal straightforward solution
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int size = Integer.MIN_VALUE;
        int center = 0;
        for (int key : graph.keySet()) {
            int currentSize = graph.get(key).size();
            if (currentSize > size) {
                size = currentSize;
                center = key;
            }
        }
        
        return center;
    }
    
    public Map<Integer, List<Integer>> buildGraph(int [][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int length = edges.length;
        for (int [] e : edges) {
            map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
        }
        return map;
    }
        
        // 1 liner solution
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
