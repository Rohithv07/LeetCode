class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for (int i=0; i<n; i++) {
            int current = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            if (map.containsKey(current))
                temp = map.get(current);
            temp.add(i);
            map.put(current, temp);
            if (temp.size() == current) {
                result.add(temp);
                map.remove(current);
            }
        }
        return result;
    }
}
