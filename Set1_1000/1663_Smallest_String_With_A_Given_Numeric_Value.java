class Solution {
    public String getSmallestString(int n, int k) {
        // 1. make a character array of length n
        char [] characters = new char[n];
        // 2. fill the array with character a
        Arrays.fill(characters, 'a');
        // 3. Guarantee each character value is atleast1
        k -= n;
        for (int i=n-1; i>=0 && k>0; i--) {
            // put values possible
            characters[i] += Math.min(25, k);
            k -= Math.min(25, k);
        }
        // return the string
        return String.valueOf(characters);
    }
}
