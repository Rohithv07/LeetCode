class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int [] result = new int [k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int [] log : logs) {
            map.computeIfAbsent(log[0], x -> new HashSet<>()).add(log[1]);
        }
        for (int key : map.keySet()) {
            result[map.get(key).size() - 1] += 1;
        }
        return result;
    }
}
