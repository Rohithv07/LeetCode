class Solution {
    public int largestAltitude(int[] gain) {
        // int [] newArray = new int [gain.length + 1];
        // newArray[0] = 0;
        // for (int i=0; i<gain.length; i++) {
        //     newArray[i + 1] = newArray[i] + gain[i];
        // }
        // return Arrays.stream(newArray).max().getAsInt();
        int max = 0;
        int sum = 0;
        for (int number : gain) {
            sum = sum + number;
            max = Math.max(max, sum);
        }
        return max;
    }
}
