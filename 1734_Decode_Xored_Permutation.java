class Solution {
    public int[] decode(int[] encoded) {
        // int length = encoded.length + 1;
        // int a = 0;
        // int [] result = new int [length];
        // for (int i=0; i<=length; i++) {
        //     a ^= i;
        //     if (i < length && i % 2 == 1)
        //         a ^= encoded[i];
        // }
        // result[0] = a;
        // for (int i=0; i<length - 1; i++) {
        //     result[i + 1] = result[i] ^ encoded[i];
        // }
        // return result;
        int length = encoded.length + 1;
        int [] result = new int [length];
        int totalXor = 0;
        for (int i=1; i<=length; i++) {
            totalXor ^= i;
        }
        int temp = 0;
        for (int i=1; i<encoded.length; i+=2)
            temp ^= encoded[i];
        int firstNumber = totalXor ^ temp;
        result[0] = firstNumber;
        for (int i=1; i<length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }
}


// https://www.youtube.com/watch?v=I5-uDlbwbOA
