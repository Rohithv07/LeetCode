class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length; 
        if (k >= n) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int consecutiveWin = 0;
        int currentWinner = arr[0];
        for (int i=1; i<n; i++) {
            if (currentWinner < arr[i]) {
                currentWinner = arr[i];
                consecutiveWin = 0;
            }
            if (++consecutiveWin == k)
                break;
        }
        return currentWinner;
    }
}
