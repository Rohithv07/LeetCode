// if we encounter a 0, then we look the previous and next values by considering the boundary and update next and previous as a[i+1]
// and a[i-1] respectively. If both next and previous comes to another 0's, then we can place the flower so we can increase the count.

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int count = 0;
        for (int i=0; i<length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == length - 1) ? 0 : flowerbed[i+1];
                int previous = (i == 0) ? 0 : flowerbed[i-1];
                if (next == 0 && previous == 0) {
                    flowerbed[i] = 1; // avoid conflit as we plant a flower
                    count += 1;
                }
            }
        }
        return count == n;
    }
}
