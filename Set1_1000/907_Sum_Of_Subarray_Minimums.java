class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        long mod = (long)1e9 + 7;
        long result = 0;
        Stack<int[]> previousLess = new Stack<>();
        Stack<int[]> nextLess = new Stack<>();
        int [] left = new int [length];
        int [] right = new int [length];
        // previous less element - imagine 2, 5, 6, 5 you don't want to double count so you can either enforce the = on the left or right array.
        for (int i=0; i<length; i++) {
            while (!previousLess.isEmpty() && previousLess.peek()[0] >= arr[i]) {
                previousLess.pop();
            }
            left[i] = previousLess.isEmpty() ? i + 1 : i - previousLess.peek()[1];
            previousLess.push(new int []{arr[i], i});
        }
        // next less element. for this we do reverse traversal
        for (int i=length - 1; i>=0; i--) {
            while (!nextLess.isEmpty() && nextLess.peek()[0] > arr[i]) {
                nextLess.pop();
            }
            right[i] = nextLess.isEmpty() ? length - i : nextLess.peek()[1] - i;
            nextLess.push(new int [] {arr[i], i});
        }
        for (int i=0; i<length; i++) {
            result = (result + (long) arr[i] * left[i] * right[i]) % mod; 
        }
        return (int)result;
    }
}
