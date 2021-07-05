class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // count occurance from arr1
        for (int number : arr1) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        // fill the array
        int index = 0;
        for (int number : arr2) {
            for (int j=0; j<map.get(number); j++) {
                arr1[index++] = number;
            }
            // remove the processed number from map
            map.remove(number);
        }
        // continue with the remainings in treemap
        for (int key : map.keySet()) {
            for (int j=0; j<map.get(key); j++) {
                arr1[index++] = key;
            }
        }
        return arr1;
    }
}
