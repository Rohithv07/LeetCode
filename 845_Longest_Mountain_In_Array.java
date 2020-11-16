class Solution {
    public int longestMountain(int[] A) {
        int length = A.length;
        if (length <= 1)
            return 0;
        int up = 0;
        int down = 0;
        int mountainLength = 0;
        for (int i=1; i<length; i++) {
            if ((down>0 && A[i-1]<A[i]) || A[i-1] == A[i]) {
                up = 0;
                down = 0;
            }
            if (A[i-1] < A[i])
                up += 1;
            if (A[i-1] > A[i])
                down += 1;
            if (down>0 && up>0 && up+down+1>mountainLength)
                mountainLength = up + down + 1;
        }
        return mountainLength < 3 ? 0 : mountainLength;
    }
}
