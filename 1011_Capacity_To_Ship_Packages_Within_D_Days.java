class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = totalSum(weights);
        while (left < right) {
            int middle = left + (right-left) / 2;
            if (leastWeight(middle, weights, D))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    public boolean leastWeight(int middle, int [] weights, int D) {
        int answer = 1;
        int min = 0;
        for (int i=0; i<weights.length; i++) {
            min += weights[i];
            if (min > middle) {
                min = weights[i];
                answer += 1;
                if (answer > D)
                    return false;
            }
        }
        return true;
    }
    public int totalSum(int [] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) 
            sum += array[i];
        return sum;
    }
}
