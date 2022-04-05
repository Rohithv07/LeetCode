1.Its the common pattern for the binary search and in this case we need to find the maximum candies that can be allocated to K students where each of them get equal amount of candies.
2.So we can give 0 candies in minimum or we can give max(candies) to the students
3.Thus our search space will be 0 to max(candies)
4.Apply our binary search concept.
5.Find the middle and check if middle amount of candies can be distributed to k students, if yes, we need to find maximum, so we think there is more optimal answer to the right of our search space that will maximize our result, so update low = middle + 1 and store result = middle.
6.If we are not able to distribute middle amount of candies to k number of students, then any candies to the right of middle is also of no use, we need to explore the left part and move right = middle - 1;
7.Finally return our result.





class Solution {
    public int maximumCandies(int[] candies, long k) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        int low = 0;
        int high = findMax(candies);
        return binarySearch(candies, k, low, high);
    }
    
    public int binarySearch(int [] candies, long k, int low, int high) {
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (isPossibleToDivide(candies, middle, k)) {
                result = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return result;
    }
    
    public boolean isPossibleToDivide(int [] candies, int inHand, long k) {
        if (inHand == 0) {
            return true;
        }
        long total = 0;
        for (int num : candies) {
            total += (num) / inHand;
            if (total >= k) {
                return true;
            }
        }
        return false;
    }
    
    public int findMax(int [] candies) {
        int max = 0;
        for (int num : candies) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}