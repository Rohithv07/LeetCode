class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        while (lowLimit <= highLimit) {
            int sum = sumOfDigit(lowLimit);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            lowLimit += 1;
        }
        int max = Integer.MIN_VALUE;
        for (int number : map.keySet()) {
            int val = map.get(number);
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
    
    public int sumOfDigit(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }
}
