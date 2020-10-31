// in place

class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            arr[0] = -1;
            return arr;
        }
        int [] result = new int [length];
        result[length-1] = -1;
        int max = -1;
        for (int i=length-1; i>=0; i--) {
            int a = arr[i];
            arr[i] = max;
            max = Math.max(max, a);
        }
        return arr;
    }
}

// extra array for storing the output
class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            arr[0] = -1;
            return arr;
        }
        int [] result = new int [length];
        result[length-1] = -1;
        int max = arr[length-1];
        for (int i=length-2; i>=0; i--) {
            if (arr[i] > max) {
                result[i] = max;
                max = arr[i];
            }
            else
                result[i] = max;
        }
        return result;
    }
}
