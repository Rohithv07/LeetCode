class Solution {
    public int[] decrypt(int[] code, int k) {
        int [] result = new int [code.length];
        if (k == 0) {
            return result;
        }
        int length = code.length;
        int start = 1;
        int end = k;
        int sum = 0;
        if (k < 0) {
            k = -k;
            start = length - k;
            end = length - 1;
        }
        for (int i=start; i<=end; i++)
            sum += code[i];
        for (int i=0; i<length; i++) {
            result[i] = sum;
            sum -= code[(start++ % length)];
            sum += code[++end % length];
        }
        return result;
    }
}
