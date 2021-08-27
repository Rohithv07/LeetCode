/* My thought process
So here we need to consider each of the subarrays and check whether the length is odd. If its odd, then we need to consider the sum, else we continue with the next element and check for the same.

So returning  the final sum will be our required answer.
*/


class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            int temp = 0;
            for (int j=i; j<arr.length; j++) {
                temp += arr[j];
                if ((j - i + 1) % 2 == 1)
                    sum += temp;
            }
        }
        return sum;
            
    }
        
}
