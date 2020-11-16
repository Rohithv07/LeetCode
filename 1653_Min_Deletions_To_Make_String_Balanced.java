/*
My thought process: 
So here we can just locate the index of b and find how many a's are present after the b. Then update result with min(res, bcount+acount), we repeat this until we reach the end.
So we probably use 2 for loops, 1 for the normal traversing through the string and the other from the current location of b to the end of the string. So it will be O(n^2) approach
What if we store the count of a's in a separate array as suffix sum. That is just start fromt he last, if its a, make it as 1 and if its b, store the same value as in front of the element. Here we will be filling values by traversing from the back.
Now we can apply the same idea as above like finding the b and getting the count of a's from that b to the end of the string from the sum array and greedily taking the minimum.
Thats the problem.

*/


class Solution {
    public int minimumDeletions(String s) {
        if (s.length() == 1)
            return 0;
        int length = s.length();
        int [] suffixSum = new int [length];
        suffixSum[length-1] = s.charAt(length-1) == 'b' ? 0 : 1;
        for (int i=length-2; i>=0; i--) {
            if (s.charAt(i) == 'a') 
                suffixSum[i] = suffixSum[i+1] + 1;
            else
                suffixSum[i] = suffixSum[i+1];
        }
        int minimumSteps = Integer.MAX_VALUE;
        int countB = 0;
        for (int i=0; i<length; i++) {
            if (s.charAt(i) == 'b') {
                minimumSteps = Math.min(minimumSteps, countB + suffixSum[i]);
                countB += 1;
            }
        }
        minimumSteps = Math.min(minimumSteps, countB);
        return minimumSteps != Integer.MAX_VALUE ? minimumSteps : 0;
    }
}
