class Solution {
    public int lengthOfLIS(int[] array) {
        int [] LIS = new int [array.length];
        int max=0;
        for (int i=0; i<array.length; i++) {
            LIS[i] = 1;
        }
        for (int i=1; i<array.length; i++) {
            for (int j=0; j<i; j++) {
                if (array[i] > array[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }
        for (int i=0; i<LIS.length; i++) {
            if (max < LIS[i])
                max = LIS[i];
        }
        return max;
    }
}
