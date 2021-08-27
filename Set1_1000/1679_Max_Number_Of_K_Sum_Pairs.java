class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int operation = 0;
        for (int number: nums)
            map.put(number, map.getOrDefault(number, 0) + 1);
        for (int number1: map.keySet()) {
            int number2 = k - number1; // as number1 + number2 = k
            if (number1 == number2)
                operation += map.get(number1) / 2;
            else {
                if (map.containsKey(number2)) {
                    int minimum = Math.min(map.get(number1), map.get(number2));
                    operation += minimum;
                    map.put(number1, map.get(number1) - minimum);
                    map.put(number2, map.get(number2) - minimum);
                }
            }
                
        }
        return operation;
    }
}
