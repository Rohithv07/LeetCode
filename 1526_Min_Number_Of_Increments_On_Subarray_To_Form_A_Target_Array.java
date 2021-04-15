class Solution {
    public int minNumberOperations(int[] target) {
        int result = 0;
        int previous = 0;
        for (int number : target) {
            result += Math.max(number - previous, 0);
            previous = number;
        }
        return result;
    }
}
