class Solution {
    public int smallestRangeII(int[] A, int K) {
        int length = A.length;
        Arrays.sort(A);
        int answer = A[length-1] - A[0];
        for (int i=0; i<length-1; i++) {
            int num1 = A[i];
            int num2 = A[i+1];
            int high = Math.max(A[length-1] - K, num1 + K);
            int low = Math.min(A[0] + K, num2 - K);
            answer = Math.min(answer, high - low);
        }
        return answer;
    }
}