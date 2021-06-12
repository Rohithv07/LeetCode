class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for (int [] row : ranges) {
            if (left >= row[0] && left <= row[1]) {
                left = row[1] + 1;
            }
        }
        return left > right;
            
    }
}
