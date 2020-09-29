class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int [] result = new int [k];
        int length = arr.length;
        int median = arr[(length - 1) / 2]; // not the standard definition but the definition according to the question.
        int left = 0;
        int right = length - 1;
        int i = 0;
        while (left <= right) {
            if (Math.abs(arr[right] - median) >= Math.abs(median - arr[left]))
                result[i++] = arr[right--];
            else
                result[i++] = arr[left++];
            if (i == k)
                break;
        }
        return result;
    }
}
