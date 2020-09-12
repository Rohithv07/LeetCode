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
