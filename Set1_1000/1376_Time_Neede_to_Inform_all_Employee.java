// here we need to create a graph first and do the dfs on it and then inside the hlper function just find out maxvalu + informtime[currentId]

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // generate a graph using hashmap
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int id = manager[i];
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(i);
        }
        // now do the dfs to find the maximum time
        return dfsHelper(map, informTime, headID);
    }
    public int dfsHelper(Map<Integer, List<Integer>> map, int [] informTime, int currentId) {
        int maximum = 0;
        // if the graph do not have an Id, like headId, return 0
        if (!map.containsKey(currentId))
            return 0;
        for (int i=0; i<map.get(currentId).size(); i++) {
            maximum = Math.max(maximum, dfsHelper(map, informTime, map.get(currentId).get(i)));
        }
        return maximum + informTime[currentId];
    }
}
