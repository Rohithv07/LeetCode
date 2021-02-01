public class Solution {
    // you need to treat n as an unsigned value
    // Clearly, a logical AND between any number and the mask 1 gives us the least significant bit of this number. To check the next bit, we shift the mask to the left by one.
    public int hammingWeight(int n) {
        
        // method : 1
        int mask = 1;
        int noOfOne = 0;
        for (int i=0; i<32; i++) {
            if ((n & mask) != 0)
                noOfOne += 1;
            mask <<= 1;
        }
        return noOfOne;
        
        
        // method 2
        int sum = 0;
        while (n != 0) {
            sum += 1;
            n &= (n - 1);
        }
        return sum;
        
        
        
        // method 3
        return Integer.bitCount(n);
    }
}
