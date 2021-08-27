// whenever we get a 'c', then a new frog start croaking.
// whenever we get a 'k', one of the frog stops croaking.
// so we can keep track of this count and if any of tthe count gets down to 0, there is a mismatch and return -1

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int [] count = new int [5]; // C R O A K
        int currentFrog = 0;
        int maximumFrog = 0;
        for (int i=0; i<croakOfFrogs.length(); i++) {
            char currentChar = croakOfFrogs.charAt(i);
            int index = "croak".indexOf(currentChar);
            count[index] += 1;
            if (index == 0) {
                // this means we have a 'c' ie new frog
                maximumFrog = Math.max(maximumFrog, currentFrog+=1);
            }
            else if (index == 4) {
                // this means we have a 'k' ie a frog stops
                currentFrog -= 1;
            }
            else if (--count[index-1] < 0)
                //middle else if portion else if (--cnt[n - 1] < 0) not only checks if it is sequential/out of order, but also performs a key operation.cnt[n-1]-=1;
                return -1;
        }
        return currentFrog == 0 ? maximumFrog : -1;
    }
}
