class Solution {
    public int[] findErrorNums(int[] nums) {
        /*
        // 1. with hashMap
        int length = nums.length;
        int [] result = new int [2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                result[0] = key;
                break;
            }
        }
        for (int i=1; i<=length; i++) {
            if (!map.containsKey(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
        */
        int length = nums.length;
        int [] count = new int [length];
        int [] result = new int [2];
        for (int number : nums) {
            count[number - 1] += 1;
        }
        for (int i=1; i<=length; i++) {
            if (count[i - 1] == 2) {
                result[0] = i;
            }
            else if (count[i - 1] == 0)
                result[1] = i;
        }
        return result;
    }
}
