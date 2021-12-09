// ref video see allocate pages video in youtube

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h < 0) {
            return -1;
        }
        int low = 1;
        int high = findMax(piles);
        return binarySearch(piles, h, low, high);
    }
    
    public int binarySearch(int [] piles, int h, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (kokoCanEat(piles, middle, h)) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    public boolean kokoCanEat(int [] piles, int banana, int h) {
        int timeTaken = 0;
        for (int pile : piles) {
            timeTaken += (pile - 1) / banana + 1;
        }
        return timeTaken <= h;
    }
    
    public int findMax(int [] piles) {
        int max = -1;
        for (int number : piles) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}





class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (canFinish(middle, piles, H))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    public boolean canFinish(int capacity, int [] piles, int hour) {
        int total = 0;
        for (int  n: piles) 
            total += (n-1)/capacity + 1;
        return total <= hour;
    }
}
