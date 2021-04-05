class Solution {
    public boolean isIdealPermutation(int[] A) {
        // all global inversions are local inversions
        // if they  are equal then we cannot find A[i] > A[j] with i + 2 <= j
        int currentMax = 0;
        int length = A.length;
        for (int i=0; i<length - 2; i++) {
            currentMax = Math.max(currentMax, A[i]);
            if (currentMax > A[i + 2])
                return false;
        }
        return true;
        
        
        /*// brute force
        int global = findGlobal(A);
        int local = findLocal(A);
        return global == local;
    }
    
    public int findGlobal(int [] A) {
        int global = 0;
        int length = A.length;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if (A[i] > A[j])
                    global += 1;
            }
        }
        return global;
    }
    
    public int findLocal(int [] A) {
        int local = 0;
        int length = A.length;
        for (int i=0; i<length - 1; i++) {
            if (A[i] > A[i + 1])
                local += 1;
        }
        return local;
    }*/
    }
}
