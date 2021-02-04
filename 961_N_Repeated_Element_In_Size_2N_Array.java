class Solution {
    public int repeatedNTimes(int[] A) {
        int length = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : A) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == length)
                return key;
        }
        return -1;
    }
}
