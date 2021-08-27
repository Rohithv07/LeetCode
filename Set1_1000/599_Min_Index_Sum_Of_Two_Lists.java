class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i=0; i<list2.length && i <= minSum; i++) {
            int sum = 0;
            if (map.containsKey(list2[i])) {
                    sum = i + map.get(list2[i]);
                if (sum < minSum) {
                    result.clear();
                    result.add(list2[i]);
                    minSum = sum;
                }
                else if (sum == minSum) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
