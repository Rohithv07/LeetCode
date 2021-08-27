class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int number : arr) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 0)
                continue;
            // for negative number we look for x/2 and for positive number we look for x * 2
            int target = key >= 0 ? key * 2 : key / 2;
            if (key < 0 && key % 2 != 0 || map.get(key) > map.getOrDefault(target, 0))
                return false;
            map.put(target, map.get(target) - map.get(key));
        }
        return true;
    }
}