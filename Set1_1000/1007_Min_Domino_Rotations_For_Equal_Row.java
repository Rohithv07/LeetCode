// there are 4 different possibilities here
// 1. Make everything in A matches A[0]
// 2. Make everything in B matches A[0]
// 3. Make everything in A matches B[0]
// 4. Make everything in B matches B[0]

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // lets have our returning statement
        int swaps = Math.min(
        numberOfSwaps(A[0], A, B),   // means make everything in A matches A[0]
        numberOfSwaps(A[0], B, A)    // means make everything in B matches A[0]
        );

        // now we have dealt with 2 possibilities and 2 remains
        swaps = Math.min(swaps, numberOfSwaps(B[0], A, B));  // means make everything in A matches B[0]
        swaps = Math.min(swaps, numberOfSwaps(B[0], B, A));  // means make everything in B matches A[0]

        return swaps == Integer.MAX_VALUE ? -1 : swaps;
    }
    // lets complete our numberOfSwapsFunction
    public int numberOfSwaps(int target, int [] A, int [] B) {
        int count = 0;
        // we can only make a swap if element say A[index] != target but B[index] = target, if both of them are not equal to 
        // target, then we cannot make any swaps and we return Integer.MAX_VALUE
        for (int i=0; i<A.length; i++) {
            // both do not equal to the target
            if (A[i] != target && B[i] != target)
                return Integer.MAX_VALUE;
            else if (A[i] != target)
                count += 1;
        }
        return count;
    }
}
