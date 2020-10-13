class Solution {
    public int longestOnes(int[] A, int k) {
        int start = 0;
        int end;
        for (end=0; end<A.length; end++) {
            if (A[end] == 0)
                k -= 1;
            if (k<0 && A[start++] == 0)
                k += 1;
        }
        return end - start;
    }
}
