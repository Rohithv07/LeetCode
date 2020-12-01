class Solution {
    public int minDeletionSize(String[] A) {
        int length = A.length;
        int wordLength = A[0].length();
        int deletion = 0;
        int i;
        boolean [] isSorted = new boolean[length - 1];
        for (int j=0; j<wordLength; j++) {
            for (i=0; i<length-1; i++) {
                if (!isSorted[i] && A[i].charAt(j) > A[i+1].charAt(j)) {
                    // now we have to delete as its not lexicographical
                    deletion += 1;
                    break;
                }
            }
            if (i < length - 1)
                continue;
            for (int k=0; k<length-1; k++) {
                isSorted[k] |= A[k].charAt(j) < A[k+1].charAt(j);
            }
        }
        return deletion;
    }
}
