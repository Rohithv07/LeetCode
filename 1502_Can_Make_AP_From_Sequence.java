class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 0)
            return false;
        Arrays.sort(arr);
        int commonDifference = arr[1] - arr[0];
        for (int i=0; i<arr.length - 1; i++) {
            if (arr[i+1] - arr[i] != commonDifference)
                return false;
        }
        return true;
    }
}
