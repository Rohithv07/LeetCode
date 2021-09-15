class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int length = arr.length;
        int increment = 1;
        int decrement = 1;
        int result = 1;
        for (int i=1; i<length; i++) {
            if (arr[i] > arr[i - 1]) {
                increment = decrement + 1;
                decrement = 1;
            }
            else if (arr[i] < arr[i - 1]) {
                decrement = increment + 1;
                increment = 1;
            }
            else {
                increment = 1;
                decrement = 1;
            }
            result = Math.max(result, Math.max(decrement, increment));
        }
        return result;
    }
}