/*
Reference : 
"~" is the bitwise complement operator which means the negation of each bit of the input value, e.g., 00000110 -> 11111001. In this solution, the author just uses this operator to transform j to a new range so that j will not conflict with i.
*/
    
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        // build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int [] stone : stones) {
            map.computeIfAbsent(stone[0], x -> new ArrayList<>()).add(~stone[1]);
            map.computeIfAbsent(~stone[1], x -> new ArrayList<>()).add(stone[0]);
        }
        int component = 0;
        Set<Integer> visited = new HashSet<>();
        for (int [] stone : stones) {
            for (int i=0; i<2; i++) {
                int current = i == 0 ? stone[0] : ~stone[1];
                if (!visited.contains(current)) {
                    component += 1;
                    dfs(map, visited, current);
                }
            }
        }
        return n - component;
    }
    
    public void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int i) {
        if (visited.contains(i))
            return;
        visited.add(i);
        List<Integer>children = map.get(i);
        for (Integer child : children) {
            if (!visited.contains(child)) {
                dfs(map, visited, child);
            }
        } 
    }
}
