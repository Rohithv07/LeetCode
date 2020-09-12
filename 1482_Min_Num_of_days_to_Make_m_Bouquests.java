class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m*k)
            return -1;
        int left = 1;
        int right = Arrays.stream(bloomDay).max().getAsInt();
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isFeasible(bloomDay, m, k, middle))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    public boolean isFeasible(int [] bloomDay, int m, int k, int days) {
        int flowers = 0;
        int bouquets = 0;
        for (int bloom: bloomDay) {
            if (bloom > days)
                flowers = 0;
            else {
                bouquets += (flowers+1) / k;
                flowers = (flowers + 1) % k;
            }
        }
        return bouquets >= m;
    }
}
