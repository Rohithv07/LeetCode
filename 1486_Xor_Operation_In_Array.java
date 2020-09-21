class Solution {
    public int xorOperation(int n, int start) {
        int [] array = new int [n];
        int xor = 0;
        for (int i=0; i<n; i++) {
            array[i] = start + 2 * i;
            xor ^= array[i];
        }
        return xor;
    }
}
