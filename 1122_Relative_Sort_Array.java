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

// more efficient using the constraints given

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2 == null || arr2.length == 0)
            return arr1;
        if (arr1 == null || arr1.length == 0)
            return new int []{};
        int [] result = new int [arr1.length];
        int [] count = new int [1001];
        for (int number : arr1) {
            count[number] += 1;
        }
        int index = 0;
        for (int number : arr2) {
            while (count[number]-- > 0) {
                result[index++] = number;
            }
        }
        for (int i=0; i<=1000; i++) {
            while (count[i]-- > 0) {
                result[index++] = i;
            }
        }
        return result;
    }
}

// similar to custom string sorting problem 791