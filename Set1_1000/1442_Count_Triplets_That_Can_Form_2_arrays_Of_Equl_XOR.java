// O(n^2)

class Solution {
    public int countTriplets(int[] arr) {
        int length = arr.length;
        int countTriplet = 0;
        for (int i=0; i<length; i++) {
            int xor = arr[i];
            for (int j=i+1; j<length; j++) {
                xor = xor ^ arr[j];
                if (xor == 0)
                    countTriplet += j - i;
            }
        }
        return countTriplet;
    }
}
