/*
My thought process

Here we can make use of 2 pointers start and end both start at index 0.
We can make use of 2 variables say currentCount to count the freq of a character that we are dealing with and another varable maxCount to keep track of the maximum count of consecutive characters..

So lets iterate through the string starting from 0.
-> Initially start and end is at 0 and we check whether they are equal, if yes we increment currentCount by 1, if not same we reset the start to the end pointer and reset the currentCount to 1.
-> For each iteration we will be finding the maximumCount by taking max(maximumCount, currentCount.)

*/

class Solution {
    public int maxPower(String s) {
        if (s.length() == 1)
            return 1;
        int currentCount = 0;
        int maxCount = 0;
        int start = 0;
        for(int end=0; end<s.length(); end++) {
            if (s.charAt(start) == s.charAt(end)) {
                currentCount += 1;
            }
            else {
                start = end;
                currentCount = 1;
            }
            maxCount = Math.max(maxCount, currentCount);
        } 
        return maxCount;
    }
}
