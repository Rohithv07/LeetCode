class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            int middle = (left + right) / 2;
            if (x - arr[middle] > arr[middle + k] - x) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        for (int i=left; i<left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
