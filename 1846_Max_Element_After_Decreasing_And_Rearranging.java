class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int previous = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > previous) {
                previous += 1;
            }
        }
        return previous;
    }
}
